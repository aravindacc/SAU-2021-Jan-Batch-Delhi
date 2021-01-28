package com.Dishant.jaxws.beans;

import java.io.Serializable;

public class Student implements Serializable{

	private static final long serialVersionUID = -5577579081118070434L;
	
	private String name;
	private int age;
	private int student_id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getstudentId() {
		return student_id;
	}

	public void setstudentId(int student_id) {
		this.student_id = student_id;
	}
	
	@Override
	public String toString(){
		return student_id+"::"+name+"::"+age;
	}

}
