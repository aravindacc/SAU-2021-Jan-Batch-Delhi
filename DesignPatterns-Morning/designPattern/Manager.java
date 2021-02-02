package designPattern;

public class Manager extends EmployeeDetails{
	public Manager(int id , String name , String notificationMode){
		setId(id) ; 
		setName(name) ; 
		setNotificationMode(notificationMode) ; 
		setDesignation("Manager") ; 
		setSalary(800000) ; 
		setYear(10);
	}
}
