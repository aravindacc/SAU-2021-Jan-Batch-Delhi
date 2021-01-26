package org.REST.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.REST.database.Data;
import org.REST.model.Student;

public class StudentService {

	private Map<Long, Student> student= Data.getStudent();
	
	public StudentService()
	 {
		student.put(1L, new Student(1,"Vikash","1719210071"));
		person.put(2L, new Student(2,"varun","1719210089"));
	}
	
	
	public List<Student> getAllStudent() 
	{
		return new ArrayList<Student>(student.values());
	}
	
	public Student getStudent(long id)
	 {
		return student.get(id);
	}
	
	
	
	public Student updateStudent(Student student)
	 {
		if(student.getId() <= 0)
		 {
			return null;
		}
		((Map<Long, Student>) student).put(student.getId(), student);
		return student;
	}

	public Student addStudent(Student student)
	 {
		student.setId(((Map<Long, Student>) student).size() + 1);
		((Map<Long, Student>) student).put(student.getId(), student);
		return student;
	}
	
	public Student removeStudent(long id) 
	{
		return student.remove(id);
	}
	
}
