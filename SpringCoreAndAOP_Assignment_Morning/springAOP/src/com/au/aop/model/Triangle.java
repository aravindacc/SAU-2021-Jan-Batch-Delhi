package com.au.aop.model;

public class Triangle {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String setNameAndReturning(String name) {
        this.name = name;
        System.out.println("Setter Method and return the value method executed....");
        return name;
    }

}
