package com.kafka.handson.movie.producer;

import com.kafka.handson.Movie;
import com.kafka.handson.Rating;
import com.kafka.handson.movie.producer.util.MovieParser;
import java.util.Random;
import org.apache.avro.specific.SpecificRecordBase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.Resource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class MovieProducer {

  public static final String MOVIES_TOPIC = "movies";
  private final KafkaTemplate<Long, SpecificRecordBase> kafkaTemplate;

  @Value(value = "classpath:movies.dat")
  private Resource moviesFile;

  @EventListener(ApplicationStartedEvent.class)
  public void process() throws InterruptedException {
    try (Stream<String> stream = Files.lines(Paths.get(moviesFile.getURI()))) {
      stream.forEach(s -> {
        Movie movie = MovieParser.parseMovie(s);
        log.info("sending movie {} with id {} to {} topic", movie.getTitle(), movie.getMovieId(), MOVIES_TOPIC);
        kafkaTemplate.send(MOVIES_TOPIC, movie.getMovieId(), movie);
      });
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}