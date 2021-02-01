package com.spring.au;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Rectangle {

	@Autowired
	@Qualifier(value="pointObjA")
	Point pointA;
	@Autowired
	@Qualifier(value="pointObjB")
	Point pointB;
	@Autowired
	@Qualifier(value="pointObjC")
	Point pointC;
	@Autowired
	@Qualifier(value="pointObjD")
	Point pointD;

	int height;

	int width;

	Rectangle(int height,int width){
		this.height=height;
		this.width=width;
	}

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	public Point getPointD() {
		return pointD;
	}

	public void setPointD(Point pointD) {
		this.pointD = pointD;
	}

	public void draw()
	{
		System.out.println("Point A :"+this.getPointA().getX()+" "+this.getPointA().getY());
		System.out.println("Point B :"+this.getPointB().getX()+" "+this.getPointB().getY());
		System.out.println("Point C :"+this.getPointC().getX()+" "+this.getPointC().getY());
		System.out.println("Point D :"+this.getPointD().getX()+" "+this.getPointD().getY());
	}

}