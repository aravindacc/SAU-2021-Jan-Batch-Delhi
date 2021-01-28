package model;

import portal.PaySquarePortal;

import java.nio.file.Path;
import java.util.Observable;
import java.util.UUID;

public class Employee extends Observable {

    private UUID employeeId;
    private String employeeName;
    private int employeeSalary = 20000;
    private EmployeePost employeePost;   // Decorator for employee
    private boolean salaryPaid = false;

    public Employee() {

    }

    public Employee(String employeeName, EmployeePost post) {
        this.employeeId = UUID.randomUUID();
        this.employeeName = employeeName;
        employeePost = post;
    }

    public UUID getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(UUID employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(int employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public EmployeePost getEmployeePost() {
        return employeePost;
    }

    public void setEmployeePost(EmployeePost employeePost) {
        this.employeePost = employeePost;
    }

    public boolean isSalaryPaid() {
        return salaryPaid;
    }

    public void setSalaryPaid(boolean salaryPaid) {
        this.salaryPaid = salaryPaid;
        setChanged();
        notifyObservers();
    }

    public double getTotalSalary() {
        return PaySquarePortal.getInstance().getSalaryFactor(employeePost)*employeeSalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeSalary=" + employeeSalary +
                ", employeePost=" + employeePost +
                ", salaryPaid=" + salaryPaid +
                '}';
    }
}
