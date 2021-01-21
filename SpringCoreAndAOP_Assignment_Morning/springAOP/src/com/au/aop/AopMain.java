package com.au.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.au.aop.service.ShapeService;

public class AopMain {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		/*ApplicationContext ctx = new FileSystemXmlApplicationContext("spring.xml");*/
		ApplicationContext context=new FileSystemXmlApplicationContext("spring.xml");
		//ShapeService service=context.getBean("shapeService",ShapeService.class);
		//service.getCircle();
		ShapeService shapeService = context.getBean("shapeservice", ShapeService.class);
		System.out.println(shapeService.getCircle().getName());
	}

}
