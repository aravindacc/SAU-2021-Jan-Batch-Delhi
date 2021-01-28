package com.saachi.cricketexample.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saachi.cricketexample.model.CricketMatch;
import com.saachi.cricketexample.repository.CricketRepository;




@RestController
public class CricketController {
	
	 @Autowired
	 CricketRepository cricketRepository;
	    
		/*
		 * @RequestMapping("/") public String index() { return
		 * "Welcome to the CRUD application!!"; }
		 */   
	 @PostMapping("/CricketMatch")
	    public CricketMatch addCricketPlayer(@RequestBody CricketMatch newCricketMatch) {
	        return cricketRepository.save(newCricketMatch);
	    }
	    
	    
	    @GetMapping("/CricketMatch/country/{country}")
	     public CricketMatch findByCountry(@PathVariable String country){
	    	 return cricketRepository.findByCountry(country);
	    }
	    @GetMapping("/CricketMatch")
	    public List<CricketMatch> runsGreaterthan(String noOfRuns) { 
	        List<CricketMatch> haveGreaterRuns = (List<CricketMatch>) cricketRepository.findAll();
	        List<CricketMatch> playerWithRuns =  new ArrayList<CricketMatch>();
	        for (CricketMatch playerRuns : haveGreaterRuns) {
	        	if(Integer.parseInt(playerRuns.getNoOfRuns()) > Integer.parseInt(noOfRuns))
	        		playerWithRuns.add(playerRuns);
	        }
	        return playerWithRuns;
	    }
	
}
