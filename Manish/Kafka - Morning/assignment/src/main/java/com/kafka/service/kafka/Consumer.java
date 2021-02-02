package com.kafka.service.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.model.Movie;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Consumer {

    // decade -> (actor -> movies-count)
    private final Map<Integer, Map<String, Integer>> trending = new HashMap<>();
    private final List<Movie> allMovies = new ArrayList<>();

    @KafkaListener(topics = "movies", groupId = "group")
    public void consume(String movie) throws JsonProcessingException {
        Movie newMovie = createMovie(movie);
        allMovies.add(newMovie);

        int releasedDecade = newMovie.getYearReleased();
        releasedDecade = releasedDecade - (releasedDecade % 10);

        // if key does not exist
        if (!trending.containsKey(releasedDecade)) {
            trending.put(releasedDecade, new HashMap<>());
        }

        // adding to movie count for actor
        Map<String, Integer> actorsMoviesCount = trending.get(releasedDecade);
        actorsMoviesCount.put(
                newMovie.getActorName(),
                actorsMoviesCount.getOrDefault(newMovie.getActorName(), 0) + 1
        );

    }

    private Movie createMovie(String movie) {
        String[] props = movie.split("#");
        Movie movieObj = new Movie();
        movieObj.setName(props[0]);
        movieObj.setActorName(props[1]);
        movieObj.setYearReleased(Integer.parseInt(props[2]));
        return movieObj;
    }

    public Map<Integer, String> getTrendingActors() {
        Map<Integer, String> trendingActors = new HashMap<>();
        trending.forEach((key, value) -> {
            final String[] actor = new String[1];
            final int[] movieCount = {Integer.MIN_VALUE};
            value.forEach((k, v) -> {
                if (v > movieCount[0]) {
                    movieCount[0] = v;
                    actor[0] = k;
                }
            });
            trendingActors.put(key, movieCount[0] + " by " + actor[0]);
        });
        return trendingActors;
    }

    public List<Movie> getAllMovies() {
        return allMovies;
    }
}
