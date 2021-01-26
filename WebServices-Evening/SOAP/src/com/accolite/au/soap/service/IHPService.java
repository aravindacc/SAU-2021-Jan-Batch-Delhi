package com.accolite.au.soap.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.accolite.au.soap.model.Student;

@WebService(name="studentlist", targetNamespace="com.studlist")
public interface IHPService {

	@WebMethod
	Student searchById(String id) throws Exception;

	@WebMethod
	Student[] getAllStudents();

	@WebMethod
	void insertStudent(Student student);
	
	@WebMethod
	public boolean deleteStudent(int id);
	

}