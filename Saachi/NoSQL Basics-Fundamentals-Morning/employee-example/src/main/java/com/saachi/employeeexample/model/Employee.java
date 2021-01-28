package com.saachi.employeeexample.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;


@Document
public class Employee {
	
	@Id
	private String employeeId;
	
	
	 @Field
	private String firstName;
	 
	 @Field
	private String lastName;
	 
	 @Field
	private String jobTitleName;
	

	 @Field
	private String location;
	 
	    @Field
	private String pincode;
	    @Field
	private String emailAddress;
	 
	    @Field
	private String phoneNumber;
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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
	public String getJobTitleName() {
		return jobTitleName;
	}
	public void setJobTitleName(String jobTitleName) {
		this.jobTitleName = jobTitleName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Employee(String employeeId, String firstName, String lastName, String jobTitleName, String location,
			String pincode, String emailAddress, String phoneNumber) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.jobTitleName = jobTitleName;
		this.location = location;
		this.pincode = pincode;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
	}
	
	

}

