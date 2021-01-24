package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
        Rectangle rectangle = (Rectangle)factory.getBean("rectangleObject");
        Triangle triangle = (Triangle)factory.getBean("triangleObject");

        triangle.draw();
        System.out.println();
        rectangle.draw();

    }

}
