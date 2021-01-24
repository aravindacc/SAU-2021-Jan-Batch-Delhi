package org.example.model;

import org.springframework.stereotype.Component;

@Component
public class Employee {
    String name;

    public Employee(String name) {
        this.name = name;
    }

    public Employee() {
    }
    
    
    public String getName() {
        return "Inside Employoee Class getName function : "+name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

    public void throwsException() throws ArithmeticException {
        throw new ArithmeticException("Exception inside employee class");
    }
}