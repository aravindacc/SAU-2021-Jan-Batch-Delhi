package com.example.au.couchbasedemo.repository;

import com.example.au.couchbasedemo.model.CricketPlayer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CricketRepository extends CrudRepository<CricketPlayer, String> {

    Optional<CricketPlayer> findByPlayerName(String name);
}
