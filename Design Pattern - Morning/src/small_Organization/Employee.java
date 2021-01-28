package small_Organization;

public interface Employee {
    public  int getempId(); 
    public String getName(); 
    public String getEmail();
    public String getAddress();
    public long getPhoneNumber(); 
    public double getSalary();  
    public void print();  
    public void add(Employee employee);  
    public void remove(Employee employee);  
    public Employee getChildren(int e); 
    public String getnotifyMode();
    public void Notify();
}
