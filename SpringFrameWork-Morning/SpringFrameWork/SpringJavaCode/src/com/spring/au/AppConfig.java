package com.spring.au;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean(name="triangleObj")
	public Triangle getTriangle() {
		return new Triangle("Equilateral", 30, 30);
	}

	@Bean(name="RectangleObj")
	public Rectangle getRectangle() {
		return new Rectangle();
	}

	@Bean(name="Point1")
	public Point getPoint1() {
		return new Point(50,30);
	}

	@Bean(name="Point2")
	public Point getPoint2() {
		return new Point(20,40);
	}

	@Bean(name="Point3")
	public Point getPoint3() {
		return new Point(15,25);
	}

	@Bean(name="Point4")
	public Point getPoint4() {
		return new Point(30,10);
	}



}
