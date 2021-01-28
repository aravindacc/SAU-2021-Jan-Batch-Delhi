package designPattern;

public class EmployeeDetails {
	private int id ; 
	private String name ; 
	private String designation ; 
	private double salary ; 
	private String notificationMode ; 
	private  int year;
	
	public  void setId(int id){
		this.id = id ; 
	}
	public  void setName(String name){
		this.name = name ; 
	}
	public  void setDesignation(String designation){
		this.designation = designation ; 
	}
	public  void setSalary(double salary){
		this.salary = salary ; 
	}

	public void setYear(int year) {
		this.year = year;
	}

	public  void setNotificationMode(String mode){
		this.notificationMode = mode ; 
	}
	
	public void sendNotification()
	{
		if(year>=10)
		{
			salary = salary*1.2;
		}
		System.out.println("Notification is send to " + this.name + " via " + this.notificationMode + ". His salary is " + salary);  ;
	}


	
}
