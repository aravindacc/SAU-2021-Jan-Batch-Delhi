package com.au.spring;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;



public class Triangle {
	
//	private List<Point> points; 
//	
//	public List<Point> getPoints(){
//		return points;
//	}
//	
//	public void setPoints(List<Point> points){
//		this.points = points;
//	}
	
//	private Point pointA;
//	private Point pointB;
//	private Point pointC;
//	
//	public Point getPointA() {
//		return pointA;
//	}
//
//	public void setPointA(Point pointA) {
//		this.pointA = pointA;
//	}
//
//	public Point getPointB() {
//		return pointB;
//	}
//
//	public void setPointB(Point pointB) {
//		this.pointB = pointB;
//	}
//
//	public Point getPointC() {
//		return pointC;
//	}
//
//	public void setPointC(Point pointC) {
//		this.pointC = pointC;
//	}

	private Map<String, Point> points; 

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
	}
	          

//		
//		Iterator<Map.Entry<String, Point>> itr=this.points.entrySet().iterator();
//		while(itr.hasNext())
//		{
//			Map.Entry<String, Point> mp=itr.next();
//			System.out.println(mp.getKey()+"{"+mp.getValue().getX()+","+mp.getValue().getY()+"}");
//		}

//	public void draw() {
		
//		for(Point point:points) {
//			System.out.println("PointA = "+point.getX()+","+point.getY());
//		}
//		System.out.println("PointA"+getPointA().getX()+"PointA"+getPointA().getY());
//		System.out.println("PointB"+getPointB().getX()+"PointB"+getPointB().getY());
//		System.out.println("PointC"+getPointC().getX()+"PointC"+getPointC().getY());
//	}

}
