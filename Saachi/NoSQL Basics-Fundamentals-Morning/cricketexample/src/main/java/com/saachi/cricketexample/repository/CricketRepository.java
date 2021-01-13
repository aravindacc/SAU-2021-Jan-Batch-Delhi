package com.saachi.cricketexample.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;

import com.saachi.cricketexample.model.CricketMatch;



public interface CricketRepository extends CrudRepository<CricketMatch, String> {
	
	CricketMatch findByName(String playerName);
	
	CricketMatch findByWickets(String noOfWickets);
	
	CricketMatch findByCountry(String country);
	
	List<CricketMatch> runsGreaterthan(String noOfRuns);
	
}
