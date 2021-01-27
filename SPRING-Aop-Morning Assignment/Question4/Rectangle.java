package com.spring.au;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "type")
public class Rectangle {


	 Map<String,Point> points;

	public Map<String, Point> getPoints() {
		return points;
	}

	public void setPoints(Map<String, Point> points) {
		this.points = points;
	}

	public void draw() {
		Iterator<Map.Entry<String, Point>> itr = this.points.entrySet().iterator();
		while(itr.hasNext()) {
			Map.Entry<String, Point>  mp = itr.next();
			System.out.println(mp.getKey()+" "+ mp.getValue().getX()
			 +","+mp.getValue().getY());
		}
	}
}
