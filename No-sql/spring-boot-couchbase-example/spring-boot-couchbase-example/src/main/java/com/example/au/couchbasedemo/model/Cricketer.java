package com.example.au.couchbasedemo.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import com.sun.istack.NotNull;

@Document
public class Cricketer {
	
    @Id
    private String cricketerId;
    
    @Field
    private String cricketerName;
    
    @Field
    private float cricketerAverage;
    
    @Field
    private int cricketerRuns;
    
    @Field
    private int cricketerWickets;
    
    public Cricketer(String cricketerId,String cricketerName, float cricketerAverage, int cricketerRuns, int cricketerWickets)
    {
    	super();
    	this.cricketerId = cricketerId;
    	this.cricketerName = cricketerName;
    	this.cricketerAverage = cricketerAverage;
    	this.cricketerRuns = cricketerRuns;
    	this.cricketerWickets = cricketerWickets;
    }
    
    public void setCricketerId(String cricketerId)
    {
    	this.cricketerId = cricketerId;
    }
    
    public String getCricketerId()
    {
    	return cricketerId;
    }

    public void setCricketerName(String cricketerName)
    {
    	this.cricketerName = cricketerName;
    }
    public String getCricketerName()
    {
    	return cricketerName;
    }
    
    public void setCricketerAverage(float cricketerAverage)
    {
    	this.cricketerAverage = cricketerAverage;
    }
    public float getCricketerAverage()
    {
    	return cricketerAverage;
    } 
   
    
    public void setCricketerRuns(int cricketerRuns)
    {
    	this.cricketerRuns = cricketerRuns;
    }
    public int getCricketerRuns()
    {
    	return cricketerRuns;
    } 

    
    public void setCricketerWickets(int cricketerWickets)
    {
    	this.cricketerWickets = cricketerWickets;
    }
    public int getCricketerWickets()
    {
    	return cricketerWickets;
    }    
    

}
