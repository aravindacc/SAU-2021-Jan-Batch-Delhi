package com.example.au.couchbasedemo.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import com.sun.istack.NotNull;

@Document
public class CricketPlayers {
    
    @Id
    @NotNull
    String playerid;
    
    
    @Field
    String playername;
    
   
    @Field
    float playeraverage;
    
  
    @Field
    int playerruns;
    
   
    @Field
    int playerwickets;

	public String getPlayerName() {
		return playername;
	}

	public void setPlayerName(String playername) {
		this.playername = playername;
	}

	public int getPlayerRuns() {
		return playerruns;
	}

	public void setPlayerRuns(int playerruns) {
		this.playerruns = playerruns;
	}
	public float getPlayerAverage() {
		return playeraverage;
	}

	public void setPlayerAverage(float playeraverage) {
		this.playeraverage = playeraverage;
	}
	public String getPlayerId() {
		return playerid;
	}
	
	public int getPlayerWickets() {
		return playerwickets;
	}

	public void setPlayerWickets(int playerwickets) {
		this.playerwickets = playerwickets;
	}

	public CricketPlayers(String playerid, String playername, int playerruns,int playerwickets) {
		super();
		this.playerid = playerid;
		this.playername = playername;
		this.playerruns = playerruns;
		this.playerwickets = playerwickets;
	
	}
    public CricketPlayers() {}
    
    
}
