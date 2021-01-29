package com.example.au.couchbasedemo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Document
public class CricketDB {
	@Id
	private String playerId;
	@Field
	private String playerName;
	@Field
	private float playerAverage;
	@Field
	private int playerRuns;
	@Field
	private int playerWicketTaken;
	
	public CricketDB(String playerId, String playerName, float playerAverage, int playerRuns, int playerWicketTaken) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.playerAverage = playerAverage;
		this.playerRuns = playerRuns;
		this.playerWicketTaken = playerWicketTaken;
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
	public float getPlayerAverage() {
		return playerAverage;
	}
	public void setPlayerAverage(float playerAverage) {
		this.playerAverage = playerAverage;
	}
	public int getPlayerRuns() {
		return playerRuns;
	}
	public void setPlayerRuns(int playerRuns) {
		this.playerRuns = playerRuns;
	}
	public int getPlayerWicketTaken() {
		return playerWicketTaken;
	}
	public void setPlayerWicketTaken(int playerWicketTaken) {
		this.playerWicketTaken = playerWicketTaken;
	}
	
	
}
