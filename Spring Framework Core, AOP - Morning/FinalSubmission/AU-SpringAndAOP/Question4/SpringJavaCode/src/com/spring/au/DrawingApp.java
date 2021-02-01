package com.spring.au;

import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class DrawingApp {

	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
//		AbstractApplicationContext factory = new FileSystemXmlApplicationContext("spring.xml");
//		factory.registerShutdownHook();


		AbstractApplicationContext factory= new AnnotationConfigApplicationContext(AppConfig.class);
		Rectangle rectangle = (Rectangle)factory.getBean("rectangle");//bean id
		rectangle.draw();
	}

}