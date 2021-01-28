package designPattern;

public class Developer extends EmployeeDetails{
	public SDE(int id , String name , String notificationMode){
		setId(id) ; 
		setName(name) ; 
		setNotificationMode(notificationMode) ; 
		setDesignation("Developer") ; 
		setSalary(600000) ; 
		setYear(15);
	}
}
