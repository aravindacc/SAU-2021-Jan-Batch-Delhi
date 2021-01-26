package org.Dishant.REST.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.Dishant.REST.database.DatabaseClass;
import org.Dishant.REST.model.Student;

public class StudentService {

	private Map<Long, Student> student= DatabaseClass.getStudent();
	
	public StudentService() {
		student.put(1L, new Student(1,"Dishant","Bulandshahr","05-07-2000"));
		student.put(2L, new Student(2,"Arun","Bulandshahr","05-10-2000"));
		student.put(3L, new Student(3,"Rahul","Noida","05-07-2000"));
	}
	
	
	public Student getStudent(long id) {
		return student.get(id);
	}
	
	public List<Student> getAllStudent() {
		return new ArrayList<Student>(student.values());
	}
	
	public Student addStudent(Student student) {
		student.setId(((Map<Long, Student>) student).size() + 1);
		((Map<Long, Student>) student).put(student.getId(), student);
		return student;
	}
	
	public Student removeStudent(long id) {
		return student.remove(id);
	}
	
	public Student updateStudent(Student student) {
		if(student.getId() <= 0) {
			return null;
		}
		((Map<Long, Student>) student).put(student.getId(), student);
		return student;
	}
	
}
