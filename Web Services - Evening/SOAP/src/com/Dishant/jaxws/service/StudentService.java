package com.Dishant.jaxws.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.Dishant.jaxws.beans.Student;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface StudentService {

	@WebMethod
	public boolean addStudent(Student s);
	
	@WebMethod
	public boolean deleteStudent(int id);
	
	@WebMethod
	public Student getStudent(int id);
	
	@WebMethod
	public Student[] getAllStudents();
}
