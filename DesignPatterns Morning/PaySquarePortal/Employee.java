package PaySquarePortal;

public class Employee {
	private int id ; 
	private String name ; 
	private String designation ; 
	private int salary ; 
	private String notificationMode ; 
	
	public  void setId(int id){
		this.id = id ; 
	}
	public  void setName(String name){
		this.name = name ; 
	}
	public  void setDesignation(String designation){
		this.designation = designation ; 
	}
	public  void setSalary(int salary){
		this.salary = salary ; 
	}
	public  void setNotificationMode(String mode){
		this.notificationMode = mode ; 
	}
	
	public void sendNotification(){
		System.out.println("Notification is send to " + this.name + " via " + this.notificationMode)  ;
	}
}
