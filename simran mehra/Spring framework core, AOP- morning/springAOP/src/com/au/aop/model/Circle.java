package com.au.aop.model;

public class Circle {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Circle(String name) {
		this.name = name;
	}
	public Circle() {
		
	}
	public void throwsException() throws ArithmeticException {
        throw new ArithmeticException("Arithmetic exception thrown inside Circle class");
    }
	
}
