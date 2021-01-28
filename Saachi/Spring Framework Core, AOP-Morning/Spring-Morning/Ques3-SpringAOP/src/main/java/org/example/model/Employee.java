package org.example.model;

import org.springframework.stereotype.Component;

@Component
public class Employee {
    String name;

    public String getName() {
        return "Inside getName function : "+name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee() {
    }

    public void throwsException() throws ArithmeticException {
        throw new ArithmeticException("Arithmetic exception thrown inside student class");
    }
}
