package com.example.au.couchbasedemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.au.couchbasedemo.model.Blogs;
import com.example.au.couchbasedemo.model.CricketDB;
import com.example.au.couchbasedemo.repository.CricketRepository;
import com.example.au.couchbasedemo.repository.EmployeeRepository;

@RestController
public class PlayerController {
	
	@Autowired
	CricketRepository cricketRepository;
	
	@PostMapping("/cricket")
    public CricketDB addNewPlayer(@RequestBody CricketDB newPlayer) {
        return cricketRepository.save(newPlayer);
    }
	
	@GetMapping("/cricket")
    public List<CricketDB> getPlayerWhoseRunsGreaterThanX(int runs) {
        List<CricketDB> responsePlayers = (List<CricketDB>) cricketRepository.findAll();
        List<CricketDB> responsePlayersWithRunsGreaterThanX =  new ArrayList<CricketDB>();
        for (CricketDB player : responsePlayers) {
        	if(player.getPlayerRuns() > runs)
        		responsePlayersWithRunsGreaterThanX.add(player);
        }
        return responsePlayersWithRunsGreaterThanX;
    }
	
	/*
	@GetMapping("/cricket?tag>={runsToBeCheckedWith}")
    public List<CricketDB> getPlayerWhoseRunsGreaterThanX2(@PathVariable int runsToBeCheckedWith) {
		return cricketRepository.findByRunsGreaterThanX(runsToBeCheckedWith);
    }
    */
}
