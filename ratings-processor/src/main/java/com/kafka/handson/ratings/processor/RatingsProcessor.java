package com.kafka.handson.ratings.processor;

import static org.apache.kafka.streams.kstream.Grouped.with;

import com.kafka.handson.Average;
import com.kafka.handson.CountAndSum;
import com.kafka.handson.Rating;
import com.kafka.handson.serdes.AvroSerdes;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KGroupedStream;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.state.KeyValueStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class RatingsProcessor {

  private final Map<String, String> serdeConfig;

  @Value("${my.topics.movies.name:movies}")
  String movieTopicName;

  @Value("${my.topics.ratings.name:ratings}")
  String ratingsTopicName;

  @Value("${my.topic.avg-ratings.name:average-ratings}")
  String avgRatingsTopicName;

  @Autowired
  public void process(StreamsBuilder streamsBuilder) {
    final KStream<Long, Rating> ratingKStream = ratingsStream(streamsBuilder,
        ratingsTopicName,
        AvroSerdes.getSpecificAvroSerde(serdeConfig));

    ratingAverageTable(ratingKStream, avgRatingsTopicName,
        AvroSerdes.getSpecificAvroSerde(serdeConfig),
        AvroSerdes.getSpecificAvroSerde(serdeConfig),
        AvroSerdes.getSpecificAvroSerde(serdeConfig));
  }

  public KStream<Long, Rating> ratingsStream(StreamsBuilder builder,
      String ratingsTopicName,
      SpecificAvroSerde<Rating> ratingsSerde) {
    return builder.stream(ratingsTopicName, Consumed.with(Serdes.Long(), ratingsSerde).withName(ratingsTopicName  + "-stream-store"));
  }

  public KTable<Long, Average> ratingAverageTable(KStream<Long, Rating> ratings,
      String avgRatingsTopicName,
      SpecificAvroSerde<Rating> ratingSerde,
      SpecificAvroSerde<CountAndSum> countAndSumSerde,
      SpecificAvroSerde<Average> averageSerde) {

    KGroupedStream<Long, Rating> ratingsById = ratings
        .map((key, rating) -> new KeyValue<>(rating.getMovieId(), rating))
        .groupByKey(with(Serdes.Long(), ratingSerde));

   KTable<Long, CountAndSum> ratingCountAndSum = ratingsById.aggregate(() -> new CountAndSum(0L, 0.0),
        (key, rating, aggregate) -> {
          aggregate.setCount(aggregate.getCount() + 1);
          aggregate.setSum(aggregate.getSum() + rating.getRating());
          return aggregate;
        },
        Materialized.with(Serdes.Long(), countAndSumSerde));

    final KTable<Long, Average> ratingAverage =
        ratingCountAndSum.mapValues(value -> new Average(value.getSum() / value.getCount()),
            Materialized.<Long, Average, KeyValueStore<Bytes, byte[]>>as("average-ratings")
                .withKeySerde(Serdes.Long())
                .withValueSerde(averageSerde));

    ratingAverage.toStream().to(avgRatingsTopicName, Produced.with(Serdes.Long(), averageSerde));
    return ratingAverage;
  }
}
