package com.payment;

public abstract class EmpSalary {
	
	private int employeeId;
	private long employeeMobileNo;
	private double employeeNetSalary;
	private double employeeCTC;
	private String employeeName;
	private String employeeEmailId;
	private String preferredNotifyChannel;
	
	
	

	public EmpSalary(int employeeId, String employeeName, long employeeMobileNo, String employeeEmailId,
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

	public long getEmployeeMobileNo() {
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
		System.out.println("Showimg employee details");
		System.out.println("Your Id is: " + this.employeeId);
		System.out.println("Name of employee: " + this.employeeName);
		System.out.println("Mobile Number: " + this.employeeMobileNo);
		System.out.println("Email ID: " + this.employeeEmailId);
		System.out.println();
	}

	public void notifyEmployeeForSalary() {
		
		if(this.preferredNotifyChannel == "Mail") {
			System.out.println("Salary total "+ this.getEmployeeNetSalary());
			System.out.println("Email has been received");
		}
		else {
			System.out.println("Salary total "+ this.getEmployeeNetSalary());
			System.out.println("SMS has been received");
		}
		
		this.displayEmployeeDetails();
	}
}
