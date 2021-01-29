package com.hemantStudentServiceController.com;

import java.util.ArrayList;
import java.util.List;

import com.hemantStudentModel.com.Student;

public class StudentWSController {
	public List<Student> studentList = new ArrayList<Student>();

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
}
