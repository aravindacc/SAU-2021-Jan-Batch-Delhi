package com.example.au.couchbasedemo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.au.couchbasedemo.model.CricketPlayers;

public interface CricketRepository extends CrudRepository<CricketPlayers, String> {
	

	List findPlayersWithMoreRun(int playerruns);
	   
}