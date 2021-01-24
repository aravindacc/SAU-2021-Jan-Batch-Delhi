package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;

@RestController // to tell it will handle the request
public class MyController {
	
	@Autowired  // to create the object, and will inject here
	private CourseService courseService;
	
	@GetMapping("/home") // to handle the home page
	public String home()
	{
		return "Welcome to rest api service";
	}
	
	@GetMapping("/courses") // to get list of all courses
	public List<Course> getCourses()
	{
		return this.courseService.getCourses();
	}
	
	@GetMapping("/courses/{courseId}") // to get course detail of particular id
	public Course getCourse(@PathVariable String courseId)
	{
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	@PostMapping("/courses") // to add new course
	public Course addCourse(@RequestBody Course course)
	{
		return this.courseService.addCourse(course);
	}
	
	@DeleteMapping("/courses/{courseId}") // to delete the course
	public String deleteCourse(@PathVariable String courseId) {
		
		this.courseService.deleteCourse(Long.parseLong(courseId));
		return "Deleted";
	}
}
