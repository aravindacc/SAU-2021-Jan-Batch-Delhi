package designPattern;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.* ; 

public class CompanyEmployees {
	public static void main(String args[]){
		List<EmployeeDetails> ListOfEmloyees = new ArrayList<>();
		EmployeeFactory factory = new EmployeeFactory() ; 
		ListOfEmloyees.add(factory.createEmployee(1, "Niket Jain",  "Intern" , "SMS")) ; 
		ListOfEmloyees.add(factory.createEmployee(2, "Rakesh Sharma",  "Developer" , "MAIL")) ;
		ListOfEmloyees.add(factory.createEmployee(3, "Naresh Sharma",  "Manager" , "SMS")) ;
		ListOfEmloyees.add(factory.createEmployee(4, "Ajay Jain",  "Developer" , "MAIL")) ;
		ListOfEmloyees.add(factory.createEmployee(5, "Naman Gupta",  "Developer" , "SMS")) ;
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime today = LocalDateTime.now(); 
		
		if(today.getDayOfMonth() == 15 && today.getHour() == 15 &&
				today.getMinute() == 0 && today.getSecond() == 0)
			{
			for(EmployeeDetails emp : ListOfEmloyees) {
				emp.sendNotification();
			}
		}
		
	}
}
