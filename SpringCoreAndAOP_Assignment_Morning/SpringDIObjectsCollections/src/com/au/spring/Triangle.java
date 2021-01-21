package com.au.spring;

import java.util.*;

public class Triangle {
	
	private Set<Point> points;
	private Map<Integer,Point> mp;
	
	public Set<Point> getPoints(){
		return points;
	}
	
	public Map<Integer,Point> getmp(){
		return mp;
	}
	
	public void setPoints(Set<Point> points){
		this.points = points;
	}
	
	public void setmp(Map<Integer,Point> mp){
		this.mp = mp;
	}
	
	private Point pointC;
	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	
	public void draw() {
		int i=1;
		for(Point point:points) {
			System.out.println("Point "+i++ +"= "+point.getX()+","+point.getY());
		}
		pointC=mp.get(1);
		System.out.println("Point "+i++ +"= "+pointC.getX()+","+pointC.getY());
	}

}
