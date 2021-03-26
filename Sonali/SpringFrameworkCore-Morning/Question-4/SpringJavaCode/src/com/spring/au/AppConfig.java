package com.spring.au;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean(name="PointA")
	public Point getPointA() {
		return new Point(10,20);
	}
	@Bean(name="PointB")
	public Point getPointB() {
		return new Point(10,20);
	}
	@Bean(name="PointC")
	public Point getPointC() {
		return new Point(60,40);
	}
	@Bean(name="PointD")
	public Point getPointD() {
		return new Point(100,200);
	}
	@Bean(name="rectangleObj")
	public Rectangle getRectangle() {
		return new Rectangle();
	}
	@Bean(name="triangleObj")
	public Triangle getTriangle() {
		return new Triangle("Equilateral",20,30);
	}
	
//	@Bean(name="pointObj")
//	public Point getPoint() {
//		return new Point(10,20);
//	}
	

}
