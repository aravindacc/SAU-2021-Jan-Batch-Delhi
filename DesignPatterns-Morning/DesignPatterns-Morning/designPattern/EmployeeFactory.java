package designPattern;

public class EmployeeFactory {
	public static EmployeeDetails createEmployee(int id , String name , String designation , String notificationMode){
		
		switch(designation){
			case "Intern" : return new Intern(id , name , notificationMode) ;
			case "SDE" : return new SDE(id , name , notificationMode) ;
			case "Manager" : return new Manager(id , name , notificationMode) ;
			default : return null ;  
		}
	}
}
