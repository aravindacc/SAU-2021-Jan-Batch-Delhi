package com.spring.au;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
        Rectangle rectangle = (Rectangle)factory.getBean("rectangleObj");
        Triangle triangle = (Triangle)factory.getBean("triangleObj");

        rectangle.show();
        System.out.println();
        triangle.show();

    }

}
