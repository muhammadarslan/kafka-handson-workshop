package com.kafka.handson.movie.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class MoviesConsumerApplication {

  public static void main(String[] args) {
    SpringApplication.run(MoviesConsumerApplication.class, args);
  }

}
