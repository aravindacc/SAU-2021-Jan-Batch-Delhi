package org.Dishant.REST.database;

import java.util.HashMap;
import java.util.Map;

import org.Dishant.REST.model.Student;


public class DatabaseClass {

	private static Map<Long, Student> student= new HashMap<>();

	
	public static Map<Long, Student> getStudent(){
		return student;
	}

}
