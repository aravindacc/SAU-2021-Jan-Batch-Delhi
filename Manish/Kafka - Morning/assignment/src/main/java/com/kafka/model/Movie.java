package com.kafka.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Movie {

    private String name;
    private String actorName;
    private int yearReleased;

    public Movie(@JsonProperty("name") String name, @JsonProperty("actorName") String actorName, @JsonProperty("yearReleased") int yearReleased) {
        this.name = name.toLowerCase();
        this.actorName = actorName.toLowerCase();
        this.yearReleased = yearReleased;
    }

    public Movie() {
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public int getYearReleased() {
        return yearReleased;
    }

    public void setYearReleased(int yearReleased) {
        this.yearReleased = yearReleased;
    }

}
