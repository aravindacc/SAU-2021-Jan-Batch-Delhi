package org.example.service;

import org.example.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("spring.xml");
        Student student = ctx.getBean("student", Student.class);
        System.out.println(student.getName());
        try{
            student.throwsException();
        }
        catch(Exception e){
            System.out.println("Catching exception thrown by Student");
        }

    }
}
