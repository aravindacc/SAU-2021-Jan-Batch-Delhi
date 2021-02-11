package com.au.kafka.controller;
import com.au.kafka.Service.MovieProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class Controller {

    private final MovieProducer producer;

    @Autowired
    KafkaController(MovieProducer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/movie")
    public void sendMessageToKafkaTopic(@RequestParam("movieName") String movieName,@RequestParam("actor") String actor,
                                        @RequestParam("actress") String actress,@RequestParam("year") int year) {
        this.producer.sendMovieData(movieName,actor,actress,year);
    }
}