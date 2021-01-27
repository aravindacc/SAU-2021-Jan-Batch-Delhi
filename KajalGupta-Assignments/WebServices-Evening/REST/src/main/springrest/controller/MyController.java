package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.student;
import com.springrest.springrest.services.studentService;

@RestController
public class MyController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/home")
	public String home()
	{
		return "Welcome to rest api service";
	}
	
	@GetMapping("/students")
	public List<Student> getStudents()
	{
		return this.studentService.getStudents();
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable String studentId)
	{
		return this.studentService.getStudent(Long.parseLong(studentId));
	}
	
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student)
	{
		return this.studentService.addStudent(student);
	}
	
	@DeleteMapping("/students/{studentId}")
	public String deleteStudent(@PathVariable String studentId) {
		
		this.studentService.deleteStudent(Long.parseLong(studentId));
		return "Deleted";
	}
}
