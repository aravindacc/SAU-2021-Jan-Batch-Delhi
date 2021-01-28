package PaySquarePortal;

public interface EmployeeDetails {

	public  int getId(); 
    public String getName(); 
    public String getEmail();
    public long getPhoneNumber(); 
    public double getSalary();  
    public void print();  
    public void add(EmployeeDetails employee);  
    public void remove(EmployeeDetails employee);  
    public EmployeeDetails getChild(int i); 
    public String getnotifyMode();
    public void Notify();
}
