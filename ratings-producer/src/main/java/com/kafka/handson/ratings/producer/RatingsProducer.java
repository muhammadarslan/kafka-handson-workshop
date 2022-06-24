package com.kafka.handson.ratings.producer;

import com.kafka.handson.Rating;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.specific.SpecificRecordBase;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RatingsProducer {

  public static final String RATINGS_TOPIC = "ratings";
  private final KafkaTemplate<Long, SpecificRecordBase> kafkaTemplate;

  @EventListener(ApplicationStartedEvent.class)
  public void process() throws InterruptedException {
    Random ran = new Random();
    while(true) {
      long movieId = ran.nextLong(5) + 1;
      double rating = 5 + ran.nextDouble(6);
      Rating rat = new Rating(movieId, rating);
      this.kafkaTemplate.send(RATINGS_TOPIC, movieId, rat);
    }
  }
}