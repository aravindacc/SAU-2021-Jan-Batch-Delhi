package com.jatin;

public class EmailObserver extends Observer{
    EmailObserver(Employee emp)
    {
        this.employee=emp;
    }
    @Override
    public void update(){
        System.out.println("Email Notification Sent");
        this.employee.salaryCredited=false;
    }
}
