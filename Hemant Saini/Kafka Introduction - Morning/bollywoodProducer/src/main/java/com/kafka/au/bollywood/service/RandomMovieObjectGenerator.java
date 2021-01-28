package com.kafka.au.bollywood.service;

import com.kafka.au.bollywood.model.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomMovieObjectGenerator {
    private List<String> actorList = new ArrayList<String>(){{add("Salman Khan"); add("Sharukh Khan");
                                                              add("Amitabh Bacchan"); add("Ayushman khurrana");
                                                              add("Rajkumar Rao"); add("Nawajudin Siddiqui");}};

    private List<String> movieNameList = new ArrayList<String>(){{add("DDLJ"); add("Sultan");
                                                                  add("Dabangg"); add("Shole");
                                                                  add("ABCD"); add("Veer");}};
    private List<String> movieGenreList = new ArrayList<String>(){{add("Sci-fi"); add("Drama");
                                                                  add("Romance"); add("Fiction");
                                                                  add("Horror"); add("Comedy");}};
    public Movie getRandomMovieObject(){
        Random random = new Random();

        String movieName = movieNameList.get(random.nextInt(6));
        String movieGenre = movieGenreList.get(random.nextInt(6));
        String movieActor = actorList.get(random.nextInt(6));
        int movieYear = 1990 + random.nextInt(31);

        return new Movie(movieName, movieGenre, movieActor, movieYear);
    }
}
