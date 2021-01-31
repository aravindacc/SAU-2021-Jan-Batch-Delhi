package com.assignment.kafkaconsumer.listener;

import com.assignment.kafkaconsumer.model.MovieDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class KafkaConsumer {

    // just for testing purpose
    @KafkaListener(topics = "Kafka_Example", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }

    HashMap<Integer,String> topTrending=new HashMap<>();
    HashMap<Integer, HashMap<String,Integer>> trackTrending=new HashMap<Integer,HashMap<String,Integer>>();


    @KafkaListener(topics = "Kafka_Example", groupId = "group_json",
            containerFactory = "userKafkaListenerFactory")
    public void consumeJson(MovieDetails newMovie) {


        HashMap<String,Integer> movieMap= new HashMap<>();

        if(trackTrending.containsKey(newMovie.getMovieYear())) {
            movieMap=trackTrending.get(newMovie.getMovieYear());
            movieMap.put(newMovie.getActorName(), movieMap.containsKey(newMovie.getActorName()) ? movieMap.get(newMovie.getActorName()) + 1 : 1);
            if(movieMap.get(newMovie.getActorName())>=movieMap.get(topTrending.get(newMovie.getActorName())))
            {
                topTrending.put(newMovie.getMovieYear(), newMovie.getActorName());
            }
        }
        else
        {
            topTrending.put(newMovie.getMovieYear(), newMovie.getActorName());
            movieMap.put(newMovie.getActorName(),1);
        }
        trackTrending.put(newMovie.getMovieYear(),movieMap);

        System.out.println("Top Trending Actor was: "+ topTrending.get(newMovie.getActorName()) + " in year: " +  newMovie.getMovieYear());


    }
}
