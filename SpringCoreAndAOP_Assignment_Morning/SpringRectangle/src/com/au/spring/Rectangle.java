package com.au.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
//import javax.annotation.Resource;
import javax.annotation.Resource;

//@Component
public class Rectangle{
	private Point PointA;
	private Point PointB;
	private Point PointC;
	private Point PointD;
	int h,w;
	Rectangle(){}
	Rectangle(int h, int w){
		this.h=h;
		this.w=w;
	}
	//@Bean(name = "rectangle")
	public Point getPointA() {
		return PointA;
	}
	
	//@Resource
	public void setPointA(Point PointA) {
		this.PointA = PointA;
	}

	public Point getPointD() {
		return PointD;
	}
	
	//@Resource
	public void setPointD(Point PointD) {
		this.PointD = PointD;
	}


	public Point getPointB() {
		return PointB;
	}


	//@Resource
	public void setPointB(Point pointB) {
		this.PointB = pointB;
	}

	public Point getPointC() {
		return PointC;
	}

	//@Resource
	public void setPointC(Point pointC) {
		this.PointC = pointC;
	}

	public void draw() {
		System.out.println("height"+h+" width"+w);
		System.out.println("PointA"+getPointA().getX()+" PointA"+getPointA().getY());
		System.out.println("PointB"+getPointB().getX()+" PointB"+getPointB().getY());
		System.out.println("PointC"+getPointC().getX()+" PointC"+getPointC().getY());
		System.out.println("PointD"+getPointD().getX()+" PointD"+getPointD().getY());
	}

}
