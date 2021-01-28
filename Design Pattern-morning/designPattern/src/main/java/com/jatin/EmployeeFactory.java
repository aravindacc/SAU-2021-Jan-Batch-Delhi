package com.jatin;

public class EmployeeFactory {

    public static Employee getEmployeeObject(String designation)
    {
        Employee employee=null;
        if(designation.equals("SDE"))
        {
            employee=new SDE();
        }
        else if(designation.equals("Intern"))
        {
            employee=new Intern();
        }
        else if(designation.equals("Manager"))
        {
            employee=new Manager();
        }
        return employee;
    }
}
