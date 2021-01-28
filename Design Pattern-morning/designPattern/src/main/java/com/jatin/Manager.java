package com.jatin;

public class Manager extends Employee{

    public Manager()
    {
        hirearchyLevel=3;
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
