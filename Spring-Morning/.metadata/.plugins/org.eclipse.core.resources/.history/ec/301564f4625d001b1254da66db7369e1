package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Person {

    @Autowired
    @Qualifier("StudentA")
    private Student StudentA;

    @Autowired
    @Qualifier("StudentB")
    private Student StudentB;

    public Student getStudentA() {
        return StudentA;
    }

    public void setStudentA(Student studentA) {
        StudentA = studentA;
    }

    public Student getStudentB() {
        return StudentB;
    }

    public void setStudentB(Student studentB) {
        StudentB = studentB;
    }

    public void displayInfo(){
        System.out.println("Name of Student A  " + getStudentA().getName());
        System.out.println("Name of Student B  " + getStudentB().getName());
    }

    public void onInit() {
        System.out.println("Person bean initialized");
    }

    public void onCleanup() {
        System.out.println("Person bean destroyed");
    }

}
