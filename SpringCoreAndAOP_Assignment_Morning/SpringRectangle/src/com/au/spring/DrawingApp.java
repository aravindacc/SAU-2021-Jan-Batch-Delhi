package com.au.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {

	public static void main(String[] args) {

		ApplicationContext context = 
				new AnnotationConfigApplicationContext(RectangleConfig.class);
		Rectangle rectangle= (Rectangle) context.getBean("rectangle");
		rectangle.draw();


	}

}
