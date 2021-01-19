package com.au.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.au.aop.service.ShapeService;

public class AopMain {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("spring.xml");
		ShapeService shapeService = ctx.getBean("shapeservice", ShapeService.class);
		
		/***************************************************************************************************/
		//										Hemant Changes Start                                       //
		/**************************************************************************************************/
		
		System.out.println("\nInside AopMain : shapeService.getCircle().setName('Big Circle') called :-");
		shapeService.getCircle().setName("Big Circle");
		
		System.out.println("\nInside AopMain : shapeService.getCircle().getName() called :-");
		System.out.println("\nShape Name : "+ shapeService.getCircle().getName() + "\n");
		
		System.out.println("\nInside AopMain : Calling getClassName() for Circle:-");
		shapeService.getCircle().getClassName();
		
		System.out.println("\nInside AopMain : Calling throwExceptionDemo() :-");
		shapeService.getTriangle().throwExceptionDemo();
		
		/***************************************************************************************************/
		//										Hemant Changes End                                       //
		/**************************************************************************************************/
		
	}

}
