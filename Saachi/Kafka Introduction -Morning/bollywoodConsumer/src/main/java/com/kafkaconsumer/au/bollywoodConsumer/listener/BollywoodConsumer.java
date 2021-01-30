package com.kafkaconsumer.au.bollywoodConsumer.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafkaconsumer.au.bollywoodConsumer.model.Movie;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class BollywoodConsumer {
    private Movie movie = null;

    @KafkaListener(topics = "MovieTopic", groupId = "bollywood_group", containerFactory = "movieKafkaListenerFactory")
    public void consumeMovies(String movieStr){
        System.out.println("\nConsumed Movie : " + movieStr);
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            movie = objectMapper.readValue(movieStr, Movie.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        //setTrending();
        //System.out.println((movie == null) ? "Movie Object Not Recieved" : movie);
    }

    @KafkaListener(topics = "TrendingTopic", groupId = "bollywood_group", containerFactory = "movieKafkaListenerFactory")
    public void consumeTrending(String trendingStr){
        System.out.println("\nTrending Actors Decade Wise (Based on movie published till now) : \n" + trendingStr);
    }

}
