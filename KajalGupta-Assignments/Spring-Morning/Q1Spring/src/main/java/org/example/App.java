package org.example;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext factory = new FileSystemXmlApplicationContext("spring.xml");
        Student student = (Student)factory.getBean("student");
        student.displayInfo();
    }
}
