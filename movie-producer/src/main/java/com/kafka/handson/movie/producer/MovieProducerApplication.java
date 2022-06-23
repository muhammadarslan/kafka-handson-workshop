package com.kafka.handson.movie.producer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MovieProducerApplication {

  public static void main(String[] args) {
    SpringApplication.run(MovieProducerApplication.class, args);
  }

  @Value("${topics.replication.factor:1}")
  Short replicationFactor;

  @Value("${topics.partitions.count:6}")
  Integer partitions;

  @Bean
  NewTopic moviesTopic() {
    return new NewTopic(MovieProducer.MOVIES_TOPIC, partitions, replicationFactor);
  }

}
