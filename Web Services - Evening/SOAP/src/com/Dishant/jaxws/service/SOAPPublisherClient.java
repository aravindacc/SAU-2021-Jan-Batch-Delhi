package com.Dishant.jaxws.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.Dishant.jaxws.beans.Student;

public class SOAPPublisherClient {

	public static void main(String[] args) throws MalformedURLException {
		URL wsdlURL = new URL("http://localhost:8888/ws/student?wsdl");
		
		
		QName qname = new QName("http://serv.jaxws.journaldev.com/", "StudentServiceImplService"); 
		
		Service serv = Service.create(wsdlURL, qname);  
		
		
		StudentService ss = serv.getPort(StudentService.class);
		
		Student std1 = new Student(); 
		std1.setName("Kratika"); 
		std1.setstudentId(1); 
		std1.setAge(30);
		Student std2 = new Student(); 
		std2.setName("Dishant"); 
		std2.setstudentId(2); 
		std2.setAge(25);
		
		
		System.out.println("Add Student Status="+ss.addStudent(std1));
		System.out.println("Add Student Status="+ss.addStudent(std2));
		
		//get Student by id
		System.out.println(ss.getStudent(1));
		
		//get all Students
		System.out.println(Arrays.asList(ss.getAllStudents()));
		
		//delete Student by id
		System.out.println("Delete Student Status="+ss.deleteStudent(2));
		
	}

}
