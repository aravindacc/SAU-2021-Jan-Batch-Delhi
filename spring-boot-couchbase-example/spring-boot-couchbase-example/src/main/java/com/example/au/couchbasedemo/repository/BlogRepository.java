package com.example.au.couchbasedemo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.au.couchbasedemo.model.Blogs;
@Repository
public interface BlogRepository extends CrudRepository<Blogs, String> {
	
	Blogs findByAuthor(String author);

	List deleteBytopicAndAuthor(String title, String author);
	   
}