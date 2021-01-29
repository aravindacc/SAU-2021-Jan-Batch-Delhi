package com.au.spring;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.Iterator;  

public class Triangle {
	
	/***************************************************************************************************/
	//										Hemant Changes Start                                       //
	/**************************************************************************************************/
	private Map<String, Point> points; 
	
	public Triangle() {
		super();
	}
	
	public Triangle(Map<String, Point> points) {
		super();
		this.points = points;
	}

	/*private Point pointA;
	private Point pointB;
	private Point pointC;
	
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
	}*/

	
	public Map<String, Point> getPoints() {
		return points;
	}

	public void setPoints(Map<String, Point> points) {
		this.points = points;
	}

	public void draw() {
		Set<Entry<String, Point>> set = points.entrySet();  
	    Iterator<Entry<String, Point>> itr=set.iterator();
		
	    while(itr.hasNext()){  
	        Entry<String, Point> entry = itr.next();
	        Point p = (Point) entry.getValue();
	        System.out.println("\n"+entry.getKey()+" : ["+ p.getX() + "," + p.getY() + "]");  
	    }
//	    for(Point point:points) {
//			System.out.println("PointA = "+point.getX()+","+point.getY());
//		}
		/*System.out.println("PointA"+getPointA().getX()+"PointA"+getPointA().getX());
		System.out.println("PointB"+getPointA().getX()+"PointB"+getPointB().getX());
		System.out.println("PointC"+getPointA().getX()+"PointC"+getPointC().getX());*/
	}

	/***************************************************************************************************/
	//										Hemant Changes End                                       //
	/**************************************************************************************************/
}
