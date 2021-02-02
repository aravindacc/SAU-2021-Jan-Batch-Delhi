package designPattern;

public class SDE extends EmployeeDetails{
	public SDE(int id , String name , String notificationMode){
		setId(id) ; 
		setName(name) ; 
		setNotificationMode(notificationMode) ; 
		setDesignation("SDE") ; 
		setSalary(100000) ; 
		setYear(15);
	}
}
