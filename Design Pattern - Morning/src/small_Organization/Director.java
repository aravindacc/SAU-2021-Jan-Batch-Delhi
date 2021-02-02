package small_Organization;

import java.util.ArrayList;  
import java.util.Iterator;  
import java.util.List; 

public class Director implements Employee{
	 private int empId;
     private String name; 
	 private String Email;
     private long PhoneNumber;
     private double salary;  
     private String notifyMode;
     private String address;
     public Director(int empId,String name,String Email,String address,long PhoneNumber,double salary,String notifyMode) {  
         this.empId=empId;      
         this.name = name;  
         this.Email=Email;
         this.PhoneNumber=PhoneNumber;
         this.salary = salary; 
         this.notifyMode=notifyMode;
         this.address=address;
        } 
     
     List<Employee> employees = new ArrayList<Employee>();  
     @Override  
     public void add(Employee employee) {  
        employees.add(employee);  
     }  
    
     @Override  
     public void remove(Employee employee) {  
      employees.remove(employee);  
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
    public String getnotifyMode() {
    	return notifyMode;
    }
    @Override
    public void Notify()
    {
		if(notifyMode=="SMS")
			System.out.println("SMS sent: Dear employee your Salary is updated");
		else
			System.out.println("Email sent: Dear employee your Salary is updated"); 
		Iterator<Employee> it = employees.iterator();  
        while(it.hasNext())  {  
          Employee employee = it.next();  
          employee.Notify();  
       } 
    }
     @Override  
     public void print() {  
      System.out.println("Id ="+getempId());  
      System.out.println("Name ="+getName());  
      System.out.println("Email ="+getEmail());  
      System.out.println("Phone Number ="+getPhoneNumber());  
      System.out.println("Address ="+getAddress());  
      System.out.println("Salary ="+getSalary());  
       
         for(int i=0;i<employees.size();i++) {
        	 Employee emp = employees.get(i);
        	 emp.print();
         }
     }
	@Override
	public int getempId() {
		// TODO Auto-generated method stub
		return empId;
	}
	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return address;
	}
	@Override
	public Employee getChildren(int e) {
		// TODO Auto-generated method stub
		return employees.get(e);
	}  

}
