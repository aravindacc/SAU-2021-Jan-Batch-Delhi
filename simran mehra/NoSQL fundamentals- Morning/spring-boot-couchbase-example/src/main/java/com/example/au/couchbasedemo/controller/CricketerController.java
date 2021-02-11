package com.example.au.couchbasedemo.controller;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.au.couchbasedemo.model.Cricketer;
import com.example.au.couchbasedemo.repository.CricketerRepository;

@RestController
public class CricketerController {
	
    @Autowired
    CricketerRepository cricketerRepository;
    
    @PostMapping("/cricketers")
    public Cricketer addCricketer(@RequestBody Cricketer newCricketer) {
        return cricketerRepository.save(newCricketer);
    }
    
    @GetMapping("/cricketers")
    public List<Cricketer> getPlayerWhoseRunsGreaterThanX(int runs) {
        List<Cricketer> allPlayers = (List<Cricketer>) cricketerRepository.findAll();
        List<Cricketer> requiredPlayers =  new ArrayList<Cricketer>();
        for (Cricketer player : allPlayers) {
        	if(player.getCricketerRuns() > runs)
        		requiredPlayers.add(player);
        }
        return requiredPlayers;
    }

}
