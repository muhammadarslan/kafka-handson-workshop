package com.kafka.handson.movie.producer.util;

import com.kafka.handson.Movie;
import com.kafka.handson.Rating;

public class MovieParser {

  public static Movie parseMovie(String text) {
    String[] tokens = text.split("\\:\\:");
    String id = tokens[0];
    String title = tokens[1];
    String releaseYear = tokens[2];
    String country = tokens[4];

    Movie movie = new Movie();
    movie.setMovieId(Long.parseLong(id));
    movie.setTitle(title);
    movie.setReleaseYear(Integer.parseInt(releaseYear));
    movie.setCountry(country);
    return movie;
  }

  public static Rating parseRating(String text) {
    String[] tokens = text.split("\\:\\:");

    String movieId = tokens[1];
    String userRating = tokens[2];

    Rating rating = new Rating();
    rating.setMovieId(Long.parseLong(movieId));
    rating.setRating(Double.parseDouble(userRating));

    return rating;
  }


}