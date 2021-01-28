package com.kafka.controller;

import com.kafka.model.Movie;
import com.kafka.service.MovieService;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public Map<Integer, String> getTopActors() {
        return movieService.getTopActors();
    }

    @GetMapping("all")
    public List<Movie>  getAllMovies() {
        return movieService.getAllMovies();
    }

    @PostMapping
    public int addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

}
