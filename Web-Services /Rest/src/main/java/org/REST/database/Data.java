package org.REST.database;


import java.util.Map;



import java.util.HashMap;


import org.REST.model.Student;


public class Data {

	private static Map<Long, Student> umap= new HashMap<>();

	
	public static Map<Long, Student> getStudent(){
		return umap;
	}

}
