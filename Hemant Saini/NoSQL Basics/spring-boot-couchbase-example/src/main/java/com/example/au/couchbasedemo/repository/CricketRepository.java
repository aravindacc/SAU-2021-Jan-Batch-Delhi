package com.example.au.couchbasedemo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.au.couchbasedemo.model.CricketDB;
import com.example.au.couchbasedemo.model.Employee;

public interface CricketRepository extends CrudRepository<CricketDB, String>{
	List findByRunsGreaterThanX(int playerRuns);
}
