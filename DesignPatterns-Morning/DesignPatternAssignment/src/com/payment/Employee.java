package com.payment;

public abstract class Employee {
	
	private int employeeId;
	private int employeeMobileNo;
	private double employeeNetSalary;
	private double employeeCTC;
	private String employeeName;
	private String employeeEmailId;
	private String preferredNotifyChannel;
	
	
	

	public Employee(int employeeId, String employeeName, int employeeMobileNo, String employeeEmailId,
			 double employeeCTC, String preferredNotifyChannel) {
		
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeMobileNo = employeeMobileNo;
		this.employeeEmailId = employeeEmailId;
		this.employeeCTC = employeeCTC;
		this.preferredNotifyChannel = preferredNotifyChannel;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public int getEmployeeMobileNo() {
		return employeeMobileNo;
	}

	public String getEmployeeEmailId() {
		return employeeEmailId;
	}

	public double getEmployeeCTC() {
		return employeeCTC;
	}
	
	public String getPreferredNotifyChannel() {
		return preferredNotifyChannel;
	}
	
	public double getEmployeeNetSalary() {
		return employeeNetSalary;
	}


	public void setEmployeeNetSalary(double employeeNetSalary) {
		this.employeeNetSalary = employeeNetSalary;
	}

	public void displayEmployeeDetails() {
		System.out.println("Your Details are:-");
		System.out.println("Id: " + this.employeeId);
		System.out.println("Name: " + this.employeeName);
		System.out.println("Mobile No: " + this.employeeMobileNo);
		System.out.println("Email-Id: " + this.employeeEmailId);
		System.out.println();
	}

	public void notifyEmployeeForSalary() {
		
		if(this.preferredNotifyChannel == "Mail") {
			System.out.println("<-------------E-Mail Received---------->");
			System.out.println("You Got your salary with INR: "+ this.getEmployeeNetSalary());
		}
		else {
			System.out.println("<-------------SMS Received---------->");
			System.out.println("You Got your salary with INR: "+ this.getEmployeeNetSalary());
		}
		
		this.displayEmployeeDetails();
	}
}
