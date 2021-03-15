package com.demo.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "users";

    @Autowired
    private KafkaTemplate<String, MoviesData> kafkaTemplate;

    public void sendMovieData(String movieName,String actor,String actress,int year) {

        MoviesData newMovie=new MoviesData();
        newMovie.setMovieName(movieName);
        newMovie.setActor(actor);
        newMovie.setActress(actress);
        newMovie.setYear(year);
        logger.info(String.format("#### -> Producing message -> %s", newMovie));
        this.kafkaTemplate.send(TOPIC, newMovie);
    }
}
