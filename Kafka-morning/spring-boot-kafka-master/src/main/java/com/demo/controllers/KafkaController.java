package com.demo.controllers;

import com.demo.engine.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final Producer producer;

    @Autowired
    KafkaController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/movie")
    public void sendMessageToKafkaTopic(@RequestParam("movieName") String movieName,@RequestParam("actor") String actor,
                                        @RequestParam("actress") String actress,@RequestParam("year") int year) {
        this.producer.sendMovieData(movieName,actor,actress,year);
    }
}
