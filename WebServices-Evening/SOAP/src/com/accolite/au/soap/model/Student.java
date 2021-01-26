package com.accolite.au.soap.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="Student")
@XmlType(propOrder= {"department", "id", "firstName", "lastName"})
public class Student {

	private String id;
	private String firstName;
	private String lastName;
	private String department;
	
	public Student() {}
	
	public Student(String id, String fn, String ln, String dept) {
		this.id = id;
		this.firstName = fn;
		this.lastName = ln;
		this.department = dept;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
}
