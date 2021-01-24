package org.example;
import java.util.Map;
import java.util.Set;

public class Employee {
	String employeeName;
	private Map<String,String> employeeDetails;
    private Set<Integer> setDemo;
    
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Map<String, String> getEmployeeDetails() {
		return employeeDetails;
	}
	public void setEmployeeDetails(Map<String, String> employeeDetails) {
		this.employeeDetails = employeeDetails;
	}
	public Set<Integer> getSetDemo() {
		return setDemo;
	}
	public void setSetDemo(Set<Integer> setDemo) {
		this.setDemo = setDemo;
	}
	
	public void displayInfo() {
		System.out.println("Employee name : "+this.employeeName);
        System.out.println("\nDetails in Map: ");
        for (Map.Entry<String, String> entry : employeeDetails.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
        System.out.println("Set Values: ");
        System.out.println(setDemo);
	}
}
