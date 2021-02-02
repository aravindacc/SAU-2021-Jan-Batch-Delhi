package designPattern;

public class Intern extends EmployeeDetails{
	
	public Intern(int id , String name , String notificationMode){
		setId(id) ; 
		setName(name) ; 
		setNotificationMode(notificationMode) ; 
		setDesignation("Intern") ; 
		setSalary(20000) ; 
		setYear(5);
	}
		
}
