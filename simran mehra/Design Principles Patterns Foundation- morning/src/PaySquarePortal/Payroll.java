package PaySquarePortal;

public class Payroll {

	public static void main(String args[]){  
	      EmployeeDetails emp1=new DeveloperIntern(1001,"simran","simran@gmail.com",987564231, 20000.0,"SMS");  
	      EmployeeDetails emp2=new SeniorDeveloper(1002,"Gaurav","gaurav@gmail.com",875496133, 70000.0,"MAIL");  
	      EmployeeDetails emp3=new Tester(1003,"Atulya","atulya@gmail.com",789558953, 37000.0,"SMS");   
	      EmployeeDetails ceo=new Manager(10000,"Sagar","sagar@gmail.com",574562662,160000.0,"EMAIL");  
	           
	      System.out.println("Notifications for Salary updation");
	      System.out.println("");
	      ceo.Notify();
	      emp1.add(emp1);
	      emp1.print();
	      System.out.println("");
	      ceo.Notify();
	      emp2.add(emp2); 
	      emp2.print();
	      System.out.println("");
	      ceo.Notify();
	      emp3.add(emp3);  
	      emp3.print();
	      System.out.println("Notifications for Salary updation");
	      ceo.print();
	          
	   }  
}
