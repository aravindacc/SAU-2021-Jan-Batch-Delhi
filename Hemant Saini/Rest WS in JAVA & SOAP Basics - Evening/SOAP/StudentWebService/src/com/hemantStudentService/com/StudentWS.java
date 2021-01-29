package com.hemantStudentService.com;

import java.util.List;
import java.util.Iterator;

import com.hemantStudentModel.com.Student;
import com.hemantStudentServiceController.com.StudentWSController;

public class StudentWS {
	public String addStudent(Student student) {
		StudentWSController studentWSController = new StudentWSController();
		List<Student> studentList = studentWSController.getStudentList();
		studentList.add(student);
		return "Student Added";
	}
	
	public String deleteStudent(int rollNo) {
		StudentWSController studentWSController = new StudentWSController();
		List<Student> studentList = studentWSController.getStudentList();
		Iterator itr = studentList.iterator(); 
        while (itr.hasNext()) 
        { 
            Student s = (Student)itr.next(); 
            if (s.getRollNo() == rollNo) {
                itr.remove(); 
                return "Student Deleted";
            }
        } 
		return "Student Not Found";
	}
}
