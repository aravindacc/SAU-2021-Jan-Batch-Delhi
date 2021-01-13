package com.example.au.couchbasedemo.controller;

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

import com.example.au.couchbasedemo.model.CricketPlayers;
import com.example.au.couchbasedemo.repository.CricketRepository;

@RestController
public class CricketController {
    
    @Autowired
    CricketRepository cricketRepository;
    
	/*
	 * @RequestMapping("/") public String index() { return
	 * "Welcome to the CRUD application!!"; }
	 */
    
    @PostMapping("/cricketPlayer")
    public CricketPlayers addCricketPlayer(@RequestBody CricketPlayers newCricketPlayer) {
        return cricketRepository.save(newCricketPlayer);
    }
    
    @GetMapping("/cricketPlayer/{id}")
    public Optional<CricketPlayers> getCricketPlayer(@PathVariable String playerid) {
        if (cricketRepository.existsById(playerid)) {
            return cricketRepository.findById(playerid);
        } else
            return Optional.empty();
    }
    
    @GetMapping("/cricketPlayer")
    public List<CricketPlayers> getPlayersWithMoreRun(@PathVariable int runs) {
    		 
    	List<CricketPlayers> responsePlayers = (List<CricketPlayers>) cricketRepository.findAll();
        List<CricketPlayers> responsePlayersWithRunsGreaterThanX =  new ArrayList<CricketPlayers>();
        for (CricketPlayers player : responsePlayers) {
        	if(player.getPlayerRuns() > runs)
        		responsePlayersWithRunsGreaterThanX.add(player);
        }
        return responsePlayersWithRunsGreaterThanX;
    }
    
  
    
	/*
	 * @PutMapping("/blogs/{idToBeUpdated}") public String updateBlog(@PathVariable
	 * String idToBeUpdated, @RequestBody BlogsUpdateRequest blogsUpdateRequest) {
	 * 
	 * Optional<Blogs> mayBeBlog = blogRepository.findById(idToBeUpdated) .map(blogs
	 * –> blogRepository .save(Blogs .builder() .id(idToBeUpdated)
	 * .topic(blogsUpdateRequest.getTopic()) .tags(blogsUpdateRequest.getTags())
	 * .author(blogs.getAuthor()) .date(blogs.getDate()) .build()) ); if
	 * (mayBeBlog.isPresent()) { return "Blog Updated"; } else { return
	 * "Blog does not exist"; } }
	 */
}