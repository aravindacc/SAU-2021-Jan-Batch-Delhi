package paysquare;

public interface Employee {
    public  int getEId(); 
    public String getName(); 
    public String getEmail();
    public long getMobileNumber(); 
  
    public void print();  
    public void add(Employee employee);  
    public void remove(Employee employee);  
    public Employee getChild(int i); 
    public String getnotifyMode();
    public void Notify();
}
