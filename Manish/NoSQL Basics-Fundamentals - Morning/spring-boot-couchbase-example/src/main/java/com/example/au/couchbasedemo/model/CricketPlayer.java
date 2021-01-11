package com.example.au.couchbasedemo.model;

import com.sun.istack.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Document
public class CricketPlayer {

    @Id
    private String id;

    @NotNull @Field
    private String playerName;

    @NotNull @Field
    private int runs;

    @NotNull @Field
    private int matchPlayed;

    @NotNull @Field
    private int noOfWickets;

    public CricketPlayer(String id, String playerName, int runs, int matchPlayed, int noOfWickets) {
        this.id = id;
        this.playerName = playerName;
        this.runs = runs;
        this.matchPlayed = matchPlayed;
        this.noOfWickets = noOfWickets;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getMatchPlayed() {
        return matchPlayed;
    }

    public void setMatchPlayed(int matchPlayed) {
        this.matchPlayed = matchPlayed;
    }

    public int getNoOfWickets() {
        return noOfWickets;
    }

    public void setNoOfWickets(int noOfWickets) {
        this.noOfWickets = noOfWickets;
    }
}
