package com.jatin;

public class NotificationObserver extends Observer{
    NotificationObserver(Employee emp)
    {
        this.employee=emp;
    }
    @Override
    public void  update()
    {
        System.out.println("Push Notification Sent");
        this.employee.salaryCredited=false;
    }
}
