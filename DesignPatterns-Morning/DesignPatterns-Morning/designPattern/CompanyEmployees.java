package designPattern;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.* ; 

public class CompanyEmployees {
	public static void main(String args[]){
		List<EmployeeDetails> ListOfEmloyees = new ArrayList<>();
		EmployeeFactory factory = new EmployeeFactory() ; 
		ListOfEmloyees.add(factory.createEmployee(1, "Katherine Pierce",  "Intern" , "SMS")) ; 
		ListOfEmloyees.add(factory.createEmployee(2, "Klaus Mikelson",  "SDE" , "MAIL")) ;
		ListOfEmloyees.add(factory.createEmployee(3, "Damon Salvatore",  "Manager" , "SMS")) ;
		ListOfEmloyees.add(factory.createEmployee(4, "Caroline Forbes",  "SDE" , "MAIL")) ;
		ListOfEmloyees.add(factory.createEmployee(5, "Kai Parker",  "SDE" , "SMS")) ;
		
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
