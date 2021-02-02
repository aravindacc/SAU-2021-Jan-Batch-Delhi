package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entities.Student;

public interface StudentService {
	
	public List<Student> getStudents();
	
	public Student getStudent(long studentId);

	public Student addStudent(Student student);

	public void deleteStudent(long parseLong);

}
