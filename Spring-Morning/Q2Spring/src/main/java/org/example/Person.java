package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Person {

    @Autowired
    @Qualifier("EmployeeA")
    private Employee EmployeeA;

    @Autowired
    @Qualifier("EmployeeB")
    private Employee EmployeeB;
    
    @Autowired
    @Qualifier("EmployeeC")
    private Employee EmployeeC;
    
    

	@Autowired
    @Qualifier("EmployeeD")
    private Employee EmployeeD;

    public Employee getEmployeeA() {
		return EmployeeA;
	}

	public void setEmployeeA(Employee employeeA) {
		EmployeeA = employeeA;
	}

	public Employee getEmployeeB() {
		return EmployeeB;
	}

	public void setEmployeeB(Employee employeeB) {
		EmployeeB = employeeB;
	}

	public Employee getEmployeeC() {
		return EmployeeC;
	}

	public void setEmployeeC(Employee employeeC) {
		EmployeeC = employeeC;
	}

	public Employee getEmployeeD() {
		return EmployeeD;
	}

	public void setEmployeeD(Employee employeeD) {
		EmployeeD = employeeD;
	}
	public void displayInfo(){
        System.out.println("Name of Employee A  " + getEmployeeA().getName());
        System.out.println("Name of Employee B  " + getEmployeeB().getName());
        System.out.println("Name of Employee C  " + getEmployeeC().getName());
        System.out.println("Name of Employee D  " + getEmployeeD().getName());
    }

    public void onInit() {
        System.out.println("Person bean initialized");
    }

    public void onCleanup() {
        System.out.println("Person bean destroyed");
    }

}
