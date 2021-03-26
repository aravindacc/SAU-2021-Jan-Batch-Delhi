package com.spring.au;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class Rectangle {
	public Rectangle() {
		super();
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
	  @Autowired
	  @Qualifier("PointA")
	  private Point pointA;
	  
	  @Autowired
	  @Qualifier("PointB")
	  private Point pointB;
	  
	  @Autowired
	  @Qualifier("PointC")
	  private Point pointC;
	  
	  @Autowired
	  @Qualifier("PointD")
	  private Point pointD;
	  //Add Non-Primitive type member variable 
	   	  
	 
		public Rectangle(Point pointA, Point pointB, Point pointC, Point pointD) {
			super();
			this.pointA = pointA;
			this.pointB = pointB;
			this.pointC = pointC;
			this.pointD = pointD;
		}

	  
	  public void draw() {
	 // System.out.println(getType()+" Triangle Drawn of type"+getType()+"with points"+getPointA().getX()+""+getPointA().getY()+"PointB "
	//		  + getPointB().getX()+""+getPointB().getY());
	  System.out.println(" Rectangle Drawn :"
		  		+ "\n Point A : ("+ getPointA().getX()+","+getPointA().getY()+") "
		  		+ "\n Point B : ("+ getPointB().getX()+","+getPointB().getY()+") "
		  		+ "\n Point C : ("+ getPointC().getX()+","+getPointC().getY()+") "
		  		+ "\n Point D : ("+ getPointD().getX()+","+getPointD().getY()+") ");
		  		
	  }

	
}
