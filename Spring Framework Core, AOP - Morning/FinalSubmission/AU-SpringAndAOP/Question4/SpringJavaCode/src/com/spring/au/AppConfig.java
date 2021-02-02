package com.spring.au;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean(name="rectangle")
	public Rectangle getTriangle() {
		return new Rectangle(10,10);
	}

	@Bean(name="pointObjA")
	public Point getPointA() {
		return new Point(10,20);
	}

	@Bean(name="pointObjB")
	public Point getPointB() {
		return new Point(20,20);
	}
	@Bean(name="pointObjC")
	public Point getPointC() {
		return new Point(30,30);
	}
	@Bean(name="pointObjD")
	public Point getPointD() {
		return new Point(40,40);
	}
}