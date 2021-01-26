package org.Dishant.REST.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
	
	private long id;
	private String name;
	private String dob;
	private String address;
	
	public Student() {
	
	}
	
	public Student(long id, String name, String address,String DOB) {
		this.id = id;
		this.name = name;
	    this.dob = DOB ;
		this.address = address;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return this.dob;
	}
	public void setDob(String Dob) {
		this.dob = Dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
