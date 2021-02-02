package small_Organization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Analyst implements Employee{
	 private int empId;
     private String name; 
	 private String Email;
	 private String address;
     private long PhoneNumber;
     private double salary; 
     public String notifyMode;
     public Analyst(int empId,String name,String Email,String address,long PhoneNumber,double salary,String notifyMode) {  
      this.empId=empId;      
      this.name = name;  
      this.Email=Email;
      this.PhoneNumber=PhoneNumber;
      this.salary = salary; 
      this.notifyMode=notifyMode;
      this.address=address;
     }   
     @Override  
     public void add(Employee employee) {  
    	 
     }  
     @Override
     public Employee getChildren(int i) { 
    	 return null;
     }  
     @Override  
     public void remove(Employee employee) {  
    	 
     } 
     @Override
 	public int getempId() {
    	 return empId; 
 	}
     @Override  
     public String getName() {  
      return name;  
     }  
     @Override  
     public String getEmail() {  
      return Email;  
     }  
     @Override  
     public long getPhoneNumber() {  
      return PhoneNumber;  
     }  
    @Override  
     public double getSalary() {  
      return salary;  
     } 
    @Override
	public String getAddress() {
		
		return this.address;
	}
    @Override
    public String getnotifyMode()
    {
    	return notifyMode;
    }
    @Override
    public void Notify()
    {
		if(getnotifyMode()=="SMS")
			System.out.println("SMS sent: Hey! your Salary is updated");
		else
			System.out.println("Email sent: Hey! your Salary is updated"); 
    }
     @Override  
     public void print() {  
         System.out.println("Id ="+getempId());  
         System.out.println("Name ="+getName());  
         System.out.println("Email ="+getEmail());  
         System.out.println("Phone Number ="+getPhoneNumber());  
         System.out.println("Address ="+getAddress());  
         System.out.println("Salary ="+getSalary());  
     }
	
	
}