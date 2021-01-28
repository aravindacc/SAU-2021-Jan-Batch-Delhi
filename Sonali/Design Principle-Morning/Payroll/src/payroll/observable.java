package payroll;

public class observable{
	public static void main(String args[]){  
	      Employee emp1=new intern(501,"Sonali Goyal","sonaligoyal@gmail.com",123456789, 50000.0,"SMS","Intern");  
	      Employee emp2=new Software_eng(502,"Sumit Kumar","sumitkumar@gmail.com",235678312, 65000.0,"MAIL","Software Engineer");  
	      Employee emp3=new senior_soft_eng(503,"Priyanka Yadav","priyankayadav@gmail.com",324561278, 90000.0,"SMS","New Software Engineer");   
	      Employee ceo=new CEO(201,"Tannu Rajput","tannurajput@gmail.com",789543671,200000.0,"EMAIL","CEO");  
	            
	          ceo.add(emp1);  
	          ceo.add(emp2);  
	          ceo.add(emp3);  
	          ceo.print();
	          System.out.println("----------------");
	          System.out.println("");
	          System.out.println("Sending notifications for the salary updation: ");
	          ceo.Notify();
	        }  
}

