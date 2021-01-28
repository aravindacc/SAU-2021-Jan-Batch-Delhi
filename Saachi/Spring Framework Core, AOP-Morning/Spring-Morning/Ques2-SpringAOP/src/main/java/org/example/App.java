package org.example;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        //Handle bean's after init/destroy activities
        AbstractApplicationContext factory = new FileSystemXmlApplicationContext("spring.xml");
        factory.registerShutdownHook();
        Person person = (Person)factory.getBean("person");//bean id
        person.displayEmployeeInfo();
    }
}
