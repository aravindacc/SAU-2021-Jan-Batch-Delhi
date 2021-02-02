package com.example.au.couchbasedemo.controller;

import com.example.au.couchbasedemo.model.CricketPlayer;
import com.example.au.couchbasedemo.repository.CricketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CricketController {

    @Autowired
    CricketRepository cricketRepository;

    // add a player
    @PostMapping("/cricket/player")
    public CricketPlayer addPlayer(@RequestBody CricketPlayer player) {
        return cricketRepository.save(player);
    }

    // get all players
    @GetMapping("/cricket/player")
    public List<CricketPlayer> getAllPlayers() {
        return (List<CricketPlayer>) cricketRepository.findAll();
    }

    // get player by id
    @GetMapping("/cricket/player/{id}")
    public Optional<CricketPlayer> getPlayerById(@PathVariable String id) {
        return cricketRepository.existsById(id) ?
                cricketRepository.findById(id) : Optional.empty();
    }

    // get player by name
    @GetMapping("/cricket/player/name/{name}")
    public Optional<CricketPlayer> getPlayerByName(@PathVariable String name) {
        return cricketRepository.findByPlayerName(name);
    }

    // get average of the player
    @GetMapping("/cricket/player/average/{id}")
    public double getAverage(@PathVariable String id) {
        Optional<CricketPlayer> player = getPlayerById(id);
        return player.isPresent() ? player.get().getRuns()/player.get().getMatchPlayed() : -1;
    }

    // get runs of the player
    @GetMapping("/cricket/player/runs/{id}")
    public double getRuns(@PathVariable String id) {
        Optional<CricketPlayer> player = getPlayerById(id);
        return player.isPresent() ? player.get().getRuns() : -1;
    }

    // get number of wickets of a player
    @GetMapping("/cricket/player/wickets/{id}")
    public int getWickets(@PathVariable String id) {
        Optional<CricketPlayer> player = getPlayerById(id);
        return player.isPresent() ? player.get().getNoOfWickets() : -1;
    }

    // get highest average
    @GetMapping("/cricket/player/highestAverage")
    public CricketPlayer getHighestAverage() {
        double maxAverage = -1;
        CricketPlayer result = null;

        // checking each player in db
        for (CricketPlayer player : cricketRepository.findAll()) {
            double average = player.getRuns() / player.getMatchPlayed() ;
            if (average > maxAverage) {
                result = player;
                maxAverage = average;
            }
        }
        return result;
    }

    // get highest wickets
    @GetMapping("/cricket/player/highestWickets")
    public CricketPlayer getHighestWickets() {
        int maxWickets = -1;
        CricketPlayer result = null;

        // checking each player in db
        for (CricketPlayer player : cricketRepository.findAll()) {
            if (player.getNoOfWickets() > maxWickets) {
                result = player;
                maxWickets = player.getNoOfWickets();
            }
        }
        return result;
    }

    // get highest runs
    @GetMapping("/cricket/player/highestRuns")
    public CricketPlayer getHighestRuns() {
        int maxRuns = -1;
        CricketPlayer result = null;

        // checking each player in db
        for (CricketPlayer player : cricketRepository.findAll()) {
            if (player.getRuns() > maxRuns) {
                result = player;
                maxRuns = player.getRuns();
            }
        }
        return result;
    }

    // get players where runs greater than a value
    @GetMapping("/cricket/player/runsGreaterThan/{runs}")
    public List<CricketPlayer> getPlayersWithMoreRunsThan(@PathVariable int runs) {
        List<CricketPlayer> result = new ArrayList<>();

        // checking each player in db
        for (CricketPlayer player : cricketRepository.findAll()) {
            if (player.getRuns() > runs) {
                result.add(player);
            }
        }

        return result;
    }

    // delete a player with id
    @DeleteMapping("/cricket/player/{id}")
    public void deletePlayer(@PathVariable String id) {
        cricketRepository.deleteById(id);
    }
}
