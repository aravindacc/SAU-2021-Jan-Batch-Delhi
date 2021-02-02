package org.REST.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
	
	private long id;
	private String name;
	private long Rollno ;
	
	
	public Student() {
	
	}
	
	public Student(long id, String name, long Rollno) {
		this.id = id;
		this.name = name;
	    this.Rollno=Rollno;
		
	}
	public long getId()
	 {
		return id;
	}
	public void setId(long id) 
	{
		this.id = id;
	}
	public long getRollno()
	 {
		return Rollno;
	}
	public void setRollno(long Rollno)
	 {
		this.Rollno = Rollno;
	}
	public String getName()
	 {
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	


}
