package com.kafka.service.kafka;

import com.kafka.model.Movie;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Properties;

@Service
public class Producer {

    private static final String TOPIC = "movies";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void addMovie(Movie movie) {
        String serialized = movie.getName()+"#"+movie.getActorName()+"#"+movie.getYearReleased();
        kafkaTemplate.send(TOPIC, serialized);
    }
}
