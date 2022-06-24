package com.kafka.handson.ratings.producer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RatingsProducerApplication {

  public static void main(String[] args) {
    SpringApplication.run(RatingsProducerApplication.class, args);
  }

  @Value("${topics.replication.factor:1}")
  Short replicationFactor;

  @Value("${topics.partitions.count:6}")
  Integer partitions;

  @Bean
  NewTopic moviesTopic() {
    return new NewTopic(RatingsProducer.RATINGS_TOPIC, partitions, replicationFactor);
  }

}
