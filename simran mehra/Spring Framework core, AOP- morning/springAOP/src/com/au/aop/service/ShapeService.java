package com.au.aop.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.au.aop.model.Circle;
//import com.au.aop.model.Triangle;

public class ShapeService {
	
	//private Circle circle;
//	private Triangle triangle;
//	public Circle getCircle() {
//		return circle;
//	}
//	public void setCircle(Circle circle) {
//		this.circle = circle;
//	}
//	public Triangle getTriangle() {
//		return triangle;
//	}
//	public void setTriangle(Triangle triangle) {
//		this.triangle = triangle;
//	}

	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("spring.xml");
	    Circle circle = ctx.getBean("circle", Circle.class);
	    System.out.println(circle.getName());
	    try{
	        circle.throwsException();
	    }
	    catch(Exception e){
	        System.out.println("Catching exception thrown by circle");
	    }
	}
}
