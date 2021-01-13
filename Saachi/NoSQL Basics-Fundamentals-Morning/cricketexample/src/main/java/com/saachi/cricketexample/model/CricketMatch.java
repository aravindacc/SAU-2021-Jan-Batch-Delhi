package com.saachi.cricketexample.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;


@Document
public class CricketMatch {

	@Id
	private String playerId;
	
	 @Field
	private String playerName;
	 

	    @Field
	private String averageRuns;
	 

	    @Field
	private String noOfRuns;
	 

	    @Field
	private String noOfWickets;
	 
	
	    @Field
	private String country;
	    
	

	public CricketMatch(String playerId, String playerName, String averageRuns, String noOfRuns, String noOfWickets,
			String country) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.averageRuns = averageRuns;
		this.noOfRuns = noOfRuns;
		this.noOfWickets = noOfWickets;
		this.country = country;
	}
	public String getPlayerId() {
		return playerId;
	}
	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getAverageRuns() {
		return averageRuns;
	}
	public void setAverageRuns(String averageRuns) {
		this.averageRuns = averageRuns;
	}
	public String getNoOfRuns() {
		return noOfRuns;
	}
	public void setNoOfRuns(String noOfRuns) {
		this.noOfRuns = noOfRuns;
	}
	public String getNoOfWickets() {
		return noOfWickets;
	}
	public void setNoOfWickets(String noOfWickets) {
		this.noOfWickets = noOfWickets;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
}
