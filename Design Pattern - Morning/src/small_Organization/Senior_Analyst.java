package small_Organization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Senior_Analyst implements Employee{
	 private int empId;
     private String name; 
	 private String Email;
     private long PhoneNumber;
     private double salary; 
     private String notifyMode;
     private String address;
     public Senior_Analyst(int empId,String name,String Email,String address,long PhoneNumber,double salary,String notifyMode) {  
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
     public void remove(Employee employee) {  
    	 
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
			System.out.println("email sent: Hey! your Salary is updated"); 
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
	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return address;
	}
	@Override
	public Employee getChildren(int e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getempId() {
		// TODO Auto-generated method stub
		return empId;
	}  

}
