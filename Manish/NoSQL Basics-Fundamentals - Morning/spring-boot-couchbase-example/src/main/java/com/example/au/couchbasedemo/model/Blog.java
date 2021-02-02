package com.example.au.couchbasedemo.model;

import com.sun.istack.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import java.util.Date;
import java.util.HashSet;

@Document
public class Blog {
    
    @Id
    String id;
    
    @NotNull @Field
    String topic;
    
    @NotNull @Field
    String author;
    
    @Field
	HashSet<String> tags;
    
    @NotNull @Field
    Date date;

	public Blog(String id, String topic, String author, HashSet<String> tags, Date date) {
		this.id = id;
		this.topic = topic;
		this.author = author;
		this.tags = tags;
		this.date = date;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public HashSet<String> getTags() {
		return tags;
	}

	public void setTags(HashSet<String> tags) {
		this.tags = tags;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getId() {
		return id;
	}
    
}
