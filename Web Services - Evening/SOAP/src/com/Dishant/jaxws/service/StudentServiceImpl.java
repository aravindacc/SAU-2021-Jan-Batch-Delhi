package com.Dishant.jaxws.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.jws.WebService;

import com.Dishant.jaxws.beans.Student;

@WebService(endpointInterface = "com.Dishant.jaxws.service.StudentService")  
public class StudentServiceImpl implements StudentService {

	private static HashMap<Integer,Student> students = new HashMap<Integer,Student>();
	
	@Override
	public boolean addStudent(Student s) {
		if(students.get(s.getstudentId()) != null) return false;
		students.put(s.getstudentId(), s);
		return true;
	}

	@Override
	public boolean deleteStudent(int st_id) {
		if(students.get(st_id) == null) 
			return false;
		
		students.remove(st_id);
		
		return true;
	}

	@Override
	public Student getStudent(int st_id) {
		return students.get(st_id);
	}

	@Override
	public Student[] getAllStudents() {
		
		Set<Integer> st_ids = students.keySet();
		Student[] p = new Student[st_ids.size()];
		int i=0;
		for(Integer id : st_ids){
			p[i] = students.get(id);
			i++;
		}
		
		return p;
	}

}
