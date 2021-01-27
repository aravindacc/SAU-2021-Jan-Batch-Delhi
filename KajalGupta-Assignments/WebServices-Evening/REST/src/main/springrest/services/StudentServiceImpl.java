package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Student;

@Service // to tell it is a Service class implementing on service class
public class StudentServiceImpl implements StudentService {

	
	List<Student> list;
	
	public StudentServiceImpl() {
		list = new ArrayList<>();
		
		list.add(new Student(1, "Kajal Gupta", "Maths"));
		list.add(new Student(2, "Harry Potter", "Magic"));
		list.add(new Student(3, "Ron Weasely", "Computer"));
		list.add(new Student(4, "Malfoy", "Science"));
	}
	
	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return list;
	}
	
	
	@Override
	public Student getStudent(long studentId)
	{
		Student c = null;
		
		for(Student student: list) 
		{
			if(student.getId() == studentId)
			{
				c = student;
				break;
			}
		}
		
		return c;
	}

	@Override
	public Student addStudent(Student student) {
		
		
		this.addStudent(student);
		return student;
	}

	@Override
	public void deleteStudent(long studentId) {
	
		for(Student student: list) 
		{
			if(student.getId() == studentId)
			{
				this.list.remove(student);
				break;
			}
		}
			
	}
	
	
	

}
