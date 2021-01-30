package com.kafka.au.bollywood.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.au.bollywood.model.Movie;
import com.kafka.au.bollywood.service.RandomMovieObjectGenerator;
import com.kafka.au.bollywood.service.TrendingActorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("bollywood")
public class BollywoodResource {

//    @Autowired
//    KafkaTemplate<String, String > kafkaTemplate;
    private static final String movieTopic = "MovieTopic";
    private static final String trendingTopic = "TrendingTopic";
    private List<String> actorList = new ArrayList<>();
//    @GetMapping("/publish/{message}")
//    public String test(@PathVariable("message") final String message){
//        kafkaTemplate.send(TOPIC, message);
//        return "Published Sucessfully!!!";
//    }

    @Autowired
    KafkaTemplate<String, String> kafkaTemplateMovie, kafkaTemplateTrending;

    RandomMovieObjectGenerator generator = new RandomMovieObjectGenerator();
    List<Movie> movieList = new ArrayList<>();
    TrendingActorUtil trendingActorUtil = new TrendingActorUtil();
    Map<String, String> trendingActorDecadeWiseMap;

    @GetMapping("/publish-movies")
    public String publishMovie(){
        int i = 0;
        while(i++<30) {
            Movie movie = generator.getRandomMovieObject();
            movieList.add(movie);
            ObjectMapper objectMapper = new ObjectMapper();
            String movieJsonObjectStr = "";
            try {
                movieJsonObjectStr = objectMapper.writeValueAsString(movie);
                kafkaTemplateMovie.send(movieTopic, movieJsonObjectStr);
                System.out.println("\nMovie Sent : " + movieJsonObjectStr);
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if(i%10 == 0)
                publishTrending();
        }
        return "Published Movies Successfully!!!";
    }

    @GetMapping("/publish-trending")
    public String publishTrending(){

        ObjectMapper objectMapper = new ObjectMapper();
        trendingActorDecadeWiseMap = trendingActorUtil.getTrendingActorDecadeWiseMap(movieList);
        String trendingActorDecadeWiseStr = "";

        try {
            trendingActorDecadeWiseStr = objectMapper.writeValueAsString(trendingActorDecadeWiseMap);
            kafkaTemplateTrending.send(trendingTopic, trendingActorDecadeWiseStr);
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Published Trending Actor Sucessfully!!!!!";
    }

}
