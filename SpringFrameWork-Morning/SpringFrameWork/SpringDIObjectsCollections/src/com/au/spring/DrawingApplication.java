package com.au.spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class DrawingApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ApplicationContext factory = new FileSystemXmlApplicationContext("spring.xml");
		Student s1 = (Student) factory.getBean("StudentBean");
		s1.show();
	}

}
