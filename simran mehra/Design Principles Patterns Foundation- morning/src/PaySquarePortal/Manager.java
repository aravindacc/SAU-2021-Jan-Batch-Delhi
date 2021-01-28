package PaySquarePortal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Manager implements EmployeeDetails{

	private int id;
    private String name; 
	 private String Email;
    private long PhoneNumber;
    private double salary;  
    private String notifyMode;
    public Manager(int id,String name,String Email,long PhoneNumber,double salary,String notifyMode) {  
     this.id=id;      
     this.name = name;  
     this.Email=Email;
     this.PhoneNumber=PhoneNumber;
     this.salary = salary; 
     this.notifyMode=notifyMode;
    }  
    List<EmployeeDetails> employees = new ArrayList<EmployeeDetails>();  
    @Override  
    public void add(EmployeeDetails employee) {  
       employees.add(employee);  
    }  
    @Override  
    public EmployeeDetails getChild(int i) {  
     return employees.get(i);  
    }  
    @Override  
    public void remove(EmployeeDetails employee) {  
     employees.remove(employee);  
    }    
    @Override
    public int getId()  {  
     return id;  
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
	   if(getnotifyMode()=="SMS")
			System.out.println("SMS Alert!! Salary updated");
		else
			System.out.println("Email Alert!! Salary updated"); 
		Iterator<EmployeeDetails> it = employees.iterator();  
       while(it.hasNext())  {  
         EmployeeDetails employee = it.next();  
         employee.Notify();  
      } 
   }
    @Override  
    public void print() {  
     System.out.println("Id ="+getId());  
     System.out.println("Name ="+getName());  
     System.out.println("Email ="+getEmail());  
     System.out.println("Phone Number ="+getPhoneNumber());  
     System.out.println("Salary ="+getSalary());  
       
     Iterator<EmployeeDetails> it = employees.iterator();  
       
         while(it.hasNext())  {  
           EmployeeDetails employee = it.next();  
           employee.print();  
        }  
    }  
}
