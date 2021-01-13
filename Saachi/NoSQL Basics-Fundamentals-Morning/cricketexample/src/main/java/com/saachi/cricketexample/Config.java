package com.saachi.cricketexample;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

@Configuration
public class Config extends AbstractCouchbaseConfiguration {
	
	 /*protected List<String> getBootstrapHosts() {
	        return Collections.singletonList("127.0.0.1");
	    }*/
   
   @Override
   public String getBucketName() {
       return "CricketMatchDetails";
   }
   
   public String getConnectionString() {
		return "127.0.0.1";
		//return "localhost";
	}

   public String getPassword() {
		return "admin1";
	}
   public String getUserName() {
		return "admin";
	}

	protected String getBucketPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	protected List<String> getBootstrapHosts() {
		// TODO Auto-generated method stub
		return null;
	}
}


