package com.spring.au;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean(name="rectangleObj")
	public Rectangle getRectangle() {
		return new Rectangle();
	}
	
	@Bean(name="triangleObj")
	public Triangle getTriangle() {
		return new Triangle("Equilateral", 10, 10);
	}
	
	@Bean(name="PointA")
	public Point getPointA() {
		return new Point(0,0);
	}
	@Bean(name="PointB")
	public Point getPointB() {
		return new Point(10,0);
	}
	@Bean(name="PointC")
	public Point getPointC() {
		return new Point(10,10);
	}
	@Bean(name="PointD")
	public Point getPointD() {
		return new Point(0,10);
	}

}
