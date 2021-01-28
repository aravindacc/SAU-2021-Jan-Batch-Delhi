package PaySquarePortal;

public class Developer extends Employee{
	public Developer(int id , String name , String notificationMode){
		setId(id) ; 
		setName(name) ; 
		setNotificationMode(notificationMode) ; 
		setDesignation("Developer") ; 
		setSalary(100000) ; 
	}
}
