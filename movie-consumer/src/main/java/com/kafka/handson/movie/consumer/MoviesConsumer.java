package com.kafka.handson.movie.consumer;

import com.kafka.handson.Movie;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MoviesConsumer {

  @KafkaListener(topics = "movies")
  public void listenMovies(
      @Payload Movie message,
      @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
      @Header(KafkaHeaders.RECEIVED_TOPIC) List<String> topics,
      @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
    log.info("topic: {}, partition: {}, offset: {}", topics.get(0), partitions.get(0), offsets.get(0));
    System.out.println("Received Message: " + message);
  }

}