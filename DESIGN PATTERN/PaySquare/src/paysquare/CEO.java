package paysquare;

import java.util.ArrayList;  
import java.util.Iterator;  
import java.util.List; 

public class CEO implements Employee{
	 private int Eid;
     private String name; 
	 private String Email;
     private long MobileNumber;
     
     private String notifyMode;
     public CEO(int Eid,String name,String Email,long MobileNumber,String notifyMode) {  
      this.Eid=Eid;      
      this.name = name;  
      this.Email=Email;
      this.MobileNumber=MobileNumber;
     
      this.notifyMode=notifyMode;
     }  
     List<Employee> employees = new ArrayList<Employee>();  
     @Override  
     public void add(Employee employee) {  
        employees.add(employee);  
     }  
        @Override  
     public Employee getChild(int i) {  
      return employees.get(i);  
     }  
     @Override  
     public void remove(Employee employee) {  
      employees.remove(employee);  
     }    
     @Override
     public int getEId()  {  
      return Eid;  
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
     public long getMobileNumber() {  
      return MobileNumber;  
     }  
   
    @Override
    public String getnotifyMode() {
    	return notifyMode;
    }
    @Override
    public void Notify()
    {
		if(getnotifyMode()=="Email" || getnotifyMode()=="SMS")
			System.out.println(" salary credited");
	
		Iterator<Employee> it = employees.iterator();  
        while(it.hasNext())  {  
          Employee employee = it.next();  
          employee.Notify();  
       } 
    }
     @Override  
     public void print() {  
      
      
      System.out.println("Name ="+getName());  
      System.out.println("Email ="+getEmail());  
      System.out.println("EId ="+getEId());  
      System.out.println("Mobile Number ="+getMobileNumber());  
     
        
     

}
