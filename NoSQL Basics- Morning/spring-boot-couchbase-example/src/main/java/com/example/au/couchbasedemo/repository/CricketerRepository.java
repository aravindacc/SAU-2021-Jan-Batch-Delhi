package com.example.au.couchbasedemo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.au.couchbasedemo.model.Cricketer;

public interface CricketerRepository extends CrudRepository<Cricketer, String>{
	List findByRunsGreaterThanX(int cricketerRuns);
}
