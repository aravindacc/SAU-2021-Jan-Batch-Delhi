package com.payment;

import java.util.ArrayList;
import java.util.List;

public class PaySquarePortal {
	
	public static void main(String[] args) {
		
		List<Employee> employeeDatabase = new ArrayList<Employee>();
	
		employeeDatabase.add(new Interns(1, "Sahil" , 1234, "abc@gmail.com", 20000.0, "Mail"));
		employeeDatabase.add(new Interns(2, "Sumit" , 3456, "pqr@gmail.com", 20000.0, "SMS"));
		
		employeeDatabase.add(new SoftwareEngineer(3, "Pankaj" , 6867, "def@gmail.com", 50000.0, "Mail"));
		employeeDatabase.add(new SeniorSoftwareEngineer(6, "Sumit" , 4633, "lia@gmail.com", 70000.0, "SMS"));
		
		employeeDatabase.add(new SeniorSoftwareEngineer(5, "Shubham" , 9643, "adf@gmail.com", 70000.0, "Mail"));
		employeeDatabase.add(new SeniorSoftwareEngineer(6, "Sumit" , 4633, "lia@gmail.com", 70000.0, "SMS"));
		
		// Will run on 15th of every month at 3 pm to calculate the salary of each of the employees and send out a notification.
		for(Employee emp: employeeDatabase) {
			emp.notifyEmployeeForSalary();
		}
	}

}
