package com.hemantStudentWSClient.com;

import javax.xml.rpc.ServiceException;

import com.hemantStudentModel.com.Student;
import com.hemantStudentService.com.StudentWS;
import com.hemantStudentService.com.StudentWSServiceLocator;

public class StudentClient {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentWSServiceLocator locator = new StudentWSServiceLocator();
		try {
			StudentWS studentWS = locator.getStudentWS();
			
			//Adding students to web service
			Student student1 = new Student(1, "Hemant", 22);
			Student student2 = new Student(2, "Sourabh", 25);
			System.out.println("Adding Student 1 :\nStatus : "+ studentWS.addStudent(student1));
			System.out.println("Adding Student 2 :\nStatus : "+ studentWS.addStudent(student2));
			
			//Deleting student into the web service database
			System.out.println("Deleting Student with roll no 2 :\nStatus : "+ studentWS.deleteStudent(1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
