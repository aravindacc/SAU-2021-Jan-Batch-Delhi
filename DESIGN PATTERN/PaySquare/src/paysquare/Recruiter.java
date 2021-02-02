package paysquare;

public class Recruiter{
	public static void main(String args[]){  
	      Employee emp1=new Hr(519,"Arun Kumar","sfg@gmail.com",123096, "SMS"); 
	      Employee emp2=new analyst(345,"Aman Raj","anne@ymail.com",78945,"SMS");   
	      Employee CEO=new CEO(100,"Durga","sdf@gmail.com",1123545,"EMAIL");  
	            
	          CEO.add(emp1);  
	          
			  CEO.add(emp2);  
			  
	          CEO.print();
	          
	          System.out.println("Message sent for salary updation");
	          CEO.Notify();
	        }  
}
