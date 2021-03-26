package com.au.aop.model;

public class Triangle {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void throwExceptionDemo() {
		// TODO Auto-generated method stub
		throw new NullPointerException("Null Pointer Eception Thrown");
	}

}
