package portal;

import model.Employee;
import model.EmployeePost;

public class EmployeeFactory {

    private static final EmployeeFactory instance = new EmployeeFactory();

    private EmployeeFactory() {}

    public static EmployeeFactory getInstance() {
        return instance;
    }

    public Employee createEmploy(String name, EmployeePost post) {
        Employee employee = new Employee(name, post);
        EmployeeObserver observer =  new EmployeeObserver(employee);
        employee.addObserver(observer);
        return employee;
    }

}
