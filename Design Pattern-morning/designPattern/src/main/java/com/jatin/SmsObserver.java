package com.jatin;

public class SmsObserver extends Observer{
    SmsObserver(Employee emp)
    {
        this.employee=emp;
    }

    @Override
    public void update()
    {
        System.out.println("Notification sent through Sms");
        this.employee.salaryCredited=false;
    }
}
