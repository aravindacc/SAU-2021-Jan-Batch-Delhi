package com.payment;

import java.util.ArrayList;
import java.util.List;

public class PaySquarePortal {
	
	public static void main(String[] args) {
		
		List<EmpSalary> employeeDatabase = new ArrayList<EmpSalary>();
	
		employeeDatabase.add(new SdeIntern(2145, "Nipun Drayan" ,999747, "Nipun@gmail.com", 20000.0, "Mail"));
		employeeDatabase.add(new SdeIntern(1414, "Raju Singh" , 845656, "Raju@gmail.com", 20000.0, "SMS"));
		
		employeeDatabase.add(new SoftwareEngineer(9653, "Arunika Srivastava" , 856225, "Arunika@gmail.com", 42000.0, "Mail"));
		employeeDatabase.add(new SoftwareEngineer(3686, "Dev Bharadwaj" , 99747, "Dev@gmail.com", 42000.0, "SMS"));
		
		employeeDatabase.add(new SeniorSoftwareEngineer(5856, "Shwetank Dhruva" , 741751, "Shwetank@gmail.com", 75000.0, "Mail"));
		employeeDatabase.add(new SeniorSoftwareEngineer(45236, "Aayash jain" , 4633, "Aayash@gmail.com", 75000.0, "SMS"));
		
		
		for(EmpSalary emp: employeeDatabase) {
			emp.notifyEmployeeForSalary();
		}
	}

}
