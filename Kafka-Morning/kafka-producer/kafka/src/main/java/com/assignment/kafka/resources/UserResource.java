package com.assignment.kafka.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("kafka")
public class UserResource {

    @Autowired
    KafkaTemplate<String, MovieDetails> kafkaTemplate;
    private static final String TOPIC = "Kafka_Example";


    // Just for checking whether producing is working or not
    @GetMapping("/publish")
    public String post(@PathVariable("message") final String message)
    {
        MovieDetails movieObj = new MovieDetails("testmovie", 2020,"Prabhas", "abc");
        kafkaTemplate.send(TOPIC, movieObj);

        return "Published Successfully...";
    }

    @PostMapping(value = "/movie")
    public String sendMessageToKafkaTopic(@RequestParam("movieName") String movieName,@RequestParam("actor") String actor,
                                        @RequestParam("year") int year, @RequestParam("genre") String genre) {
        MovieDetails tempObj = new MovieDetails(movieName, year, actor,genre);
        kafkaTemplate.send(TOPIC, tempObj);

        return "Published Successfully...";
    }
}
