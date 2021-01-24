package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Course;

@Service // to tell it is a Service class implementing on service class
public class CourseServiceImpl implements CourseService {

	
	List<Course> list;
	
	public CourseServiceImpl() {
		list = new ArrayList<>();
		
		list.add(new Course(1, "Git course", "this is a git course"));
		list.add(new Course(2, "Html course", "this is a html course"));
		list.add(new Course(3, "React course", "this is a react course"));
		list.add(new Course(4, "Rest api course", "this is a rest api course"));
	}
	
	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return list;
	}
	
	
	@Override
	public Course getCourse(long courseId)
	{
		Course c = null;
		
		for(Course course: list) 
		{
			if(course.getId() == courseId)
			{
				c = course;
				break;
			}
		}
		
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		
		
		this.addCourse(course);
		return course;
	}

	@Override
	public void deleteCourse(long courseId) {
	
		for(Course course: list) 
		{
			if(course.getId() == courseId)
			{
				this.list.remove(course);
				break;
			}
		}
			
	}
	
	
	

}
