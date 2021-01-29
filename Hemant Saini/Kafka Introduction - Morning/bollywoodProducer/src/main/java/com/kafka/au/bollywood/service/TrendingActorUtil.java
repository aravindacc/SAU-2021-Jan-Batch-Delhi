package com.kafka.au.bollywood.service;

import com.kafka.au.bollywood.model.Movie;

import java.util.*;

public class TrendingActorUtil {
    Map<String, String> trendingActorDecadeWise = new HashMap<>();
    /**
     * 1st parameter (String) : Decade
     * 2nd parameter (Map) :
     *          1st  parameter (String) : Actor Name
     *          2nd  parameter int : Movies done in this decade
     * */
    Map<String, Map<String, Integer>> decadeWiseActorMovieCount = new HashMap<>();

    public int getCurrCountOfActor(String decade, Movie movie){
        Integer currCountOfActorWrapper = decadeWiseActorMovieCount.get(decade).get(movie.getActor());
        int currCountOfActor = (currCountOfActorWrapper != null) ? currCountOfActorWrapper : 0;
        return currCountOfActor;
    }

    public String getMaxCountActor(String decade){
        Map<String, Integer> actorsAndCountsMap = decadeWiseActorMovieCount.get(decade);
        int max = -1;
        String maxCountActor = "";
        for(Map.Entry<String, Integer> entry : actorsAndCountsMap.entrySet()){
            if(entry.getValue() > max) {
                maxCountActor = entry.getKey();
                max = entry.getValue();
            }
        }
        return maxCountActor;
    }

    public Map<String, String> getTrendingActorDecadeWiseMap(List<Movie> movieList) {
        decadeWiseActorMovieCount.put("1990-2000", new HashMap<>());
        decadeWiseActorMovieCount.put("2001-2010", new HashMap<>());
        decadeWiseActorMovieCount.put("2011-2020", new HashMap<>());

        for(Movie movie : movieList){
            if(movie.getYear() >= 1990 && movie.getYear() <= 2000){
                int currCountOfActor = getCurrCountOfActor("1990-2000", movie);
                decadeWiseActorMovieCount.get("1990-2000").put(movie.getActor(), currCountOfActor+1);
            }
            else if(movie.getYear() >= 2001 && movie.getYear() <= 2010){
                int currCountOfActor = getCurrCountOfActor("2001-2010", movie);
                decadeWiseActorMovieCount.get("2001-2010").put(movie.getActor(), currCountOfActor+1);
            }
            else if(movie.getYear() >= 2011 && movie.getYear() <= 2020){
                int currCountOfActor = getCurrCountOfActor("2011-2020", movie);
                decadeWiseActorMovieCount.get("2011-2020").put(movie.getActor(), currCountOfActor+1);
            }

        }
        System.out.println("\n Decade Wise Actor Movie Count : \n"+decadeWiseActorMovieCount.toString());
        trendingActorDecadeWise.put("1990-2000", getMaxCountActor("1990-2000"));
        trendingActorDecadeWise.put("2001-2010", getMaxCountActor("2001-2010"));
        trendingActorDecadeWise.put("2011-2020", getMaxCountActor("2011-2020"));
        return trendingActorDecadeWise;
    }
}
