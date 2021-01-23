package com.au.aop.model;

public class Triangle {
	
	private String name;

	public String getName() {
		return name;
	}
	
	public void throwException() {
		throw new IllegalArgumentException();
	}

	public void setName(String name) {
		this.name = name;
	}

}
