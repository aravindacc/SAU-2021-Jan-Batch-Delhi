package com.example.au.couchbasedemo.repository;

import com.example.au.couchbasedemo.model.Blog;
import org.springframework.data.repository.CrudRepository;

public interface BlogRepository extends CrudRepository<Blog, String> {
	
	Blog findByAuthor(String author);

	void deleteByTopicAndAuthor(String topic, String author);
}