package com.spring.au;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class Triangle {

	private int width;
	private int height;
	private String type;

	@Autowired
	@Qualifier("Point1")
	private Point point1;

	@Autowired
	@Qualifier("Point2")
	private Point point2;

	@Autowired
	@Qualifier("Point3")
	private Point point3;

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Point getPoint1() {
		return point1;
	}

	public void setPoint1(Point point1) {
		this.point1 = point1;
	}

	public Point getPoint2() {
		return point2;
	}

	public void setPoint2(Point point2) {
		this.point2 = point2;
	}

	public Point getPoint3() {
		return point3;
	}

	public void setPoint3(Point point3) {
		this.point3 = point3;
	}

	public void draw() {
		System.out.println(getType()+getPoint1().getX()+","+getPoint1().getY()+
				+ getPoint2().getX()+","+getPoint2().getY()+
				+ getPoint3().getX()+","+getPoint3().getY()+ getWidth()+ getHeight());
	}

	public Triangle(Point point1, Point point2, Point point3, int width, int height, String type) {
		super();
		this.point1 = point1;
		this.point2 = point2;
		this.point3 = point3;
		this.width = width;
		this.height = height;
		this.type = type;
	}

	public Triangle(String type, int width, int height) {
		super();
		this.type = type;
		this.width = width;
		this.height = height;
	}

}