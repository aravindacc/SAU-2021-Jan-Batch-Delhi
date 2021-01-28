package PaySquarePortal;

public class DeveloperIntern implements EmployeeDetails{

	private int id;
    private String name; 
	 private String Email;
    private long PhoneNumber;
    private double salary; 
    public String notifyMode;
    public DeveloperIntern(int id,String name,String Email,long PhoneNumber,double salary,String notifyMode) {  
     this.id=id;      
     this.name = name;  
     this.Email=Email;
     this.PhoneNumber=PhoneNumber;
     this.salary = salary;  
     this.notifyMode=notifyMode;
    }    
    @Override  
    public void add(EmployeeDetails employee) {  
   	 
    }  
       @Override  
    public EmployeeDetails getChild(int i) {  
      return null;
    }  
    @Override  
    public void remove(EmployeeDetails employee) {   
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
   public String getnotifyMode()
   {
   	return notifyMode;
   }
   @Override
   public void Notify()
   {
	   if(getnotifyMode()=="SMS")
			System.out.println("SMS Alert!! Salary updated");
		else
			System.out.println("Email Alert!! Salary updated"); 
   }
    @Override  
    public void print() {  
     System.out.println("Id ="+getId());  
     System.out.println("Name ="+getName());  
     System.out.println("Email ="+getEmail());  
     System.out.println("Phone Number ="+getPhoneNumber());  
     System.out.println("Salary ="+getSalary());  
    } 
}
