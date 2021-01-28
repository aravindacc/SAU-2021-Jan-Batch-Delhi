package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Person {

    @Autowired
    @Qualifier("Emp1")
    private Employee Emp1;

    @Autowired
    @Qualifier("Emp2")
    private Employee Emp2;

    @Autowired
    @Qualifier("Emp3")
    private Employee Emp3;

    public Employee getEmp1() {
        return Emp1;
    }

    public void setEmp1(Employee emp1) {
        Emp1 = emp1;
    }

    public Employee getEmp2() {
        return Emp2;
    }

    public void setEmp2(Employee emp2) {
        Emp2 = emp2;
    }

    public Employee getEmp3() {
        return Emp3;
    }

    public void setEmp3(Employee emp3) {
        Emp3 = emp3;
    }

    public void displayEmployeeInfo(){
        System.out.println("Name of First Employee :  " + getEmp1().getName());
        System.out.println("Name of Second Employee : " + getEmp2().getName());
        System.out.println("Name of Third Employee : " + getEmp3().getName());
    }

    public void onInit() {
        System.out.println("!---Person bean initialized---!");
    }

    public void onCleanup() {
        System.out.println("!---Person bean destroyed---!");
    }

}
