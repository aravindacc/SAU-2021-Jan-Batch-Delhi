package com.jatin;

public class SDE extends Employee{

    public SDE(){
        hirearchyLevel=2;
        salary=salary+ ((salary * hirearchyLevel * 10)/100);
    }

    public void setAttributes(String empName,int empId,String type)
    {
        id=empId;
        name=empName;
        if(type.equals("SMS"))
            notificationType=new SmsObserver(this);
        else if(type.equals("Email"))
            notificationType=new EmailObserver(this);
        else if(type.equals("Push"))
            notificationType=new NotificationObserver(this);
    }
}
