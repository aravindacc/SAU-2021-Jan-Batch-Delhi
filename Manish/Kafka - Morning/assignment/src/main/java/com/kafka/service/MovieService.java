package com.kafka.service;

import com.kafka.model.Movie;
import com.kafka.service.kafka.Consumer;
import com.kafka.service.kafka.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MovieService {

    @Autowired
    private Producer producer;

    @Autowired
    private Consumer consumer;

    public Map<Integer, String> getTopActors() {
        return consumer.getTrendingActors();
    }

    public int addMovie(Movie movie) {
        producer.addMovie(movie);
        return 1;
    }

    public List<Movie> getAllMovies() {
        return consumer.getAllMovies();
    }
}
