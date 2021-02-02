package portal;

import model.Employee;
import model.EmployeePost;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaySquarePortal {

    private static final PaySquarePortal instance = new PaySquarePortal();
    private final Map<EmployeePost , Double> salaryFactor;
    private List<Employee> allEmployees = new ArrayList<>();


    private PaySquarePortal() {
        salaryFactor = Map.of(
                EmployeePost.INTERN, 1.0,
                EmployeePost.SOFTWARE_DEVELOPER, 2.0,
                EmployeePost.MANAGER, 3.0,
                EmployeePost.DIRECTOR, 4.0,
                EmployeePost.CEO, 5.0
        );
    }

    public static PaySquarePortal getInstance() {
        return instance;
    }

    public Double getSalaryFactor(EmployeePost post) {
        return salaryFactor.get(post);
    }

    public void addEmployee(Employee employee) {
        allEmployees.add(employee);
    }

    public List<Employee> getAllEmployee() {
        return allEmployees;
    }
}
