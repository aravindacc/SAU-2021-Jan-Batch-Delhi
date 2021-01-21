package com.au.spring;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RectangleConfig {

	 @Bean(name="rectangle")
	 public Rectangle getRectangle()
	 {
		 Rectangle r=new Rectangle(100,100);
		 Point p=new Point(1,2);
		 r.setPointA(p);
		 Point p2=new Point(6,2);
		 r.setPointB(p2);
		 Point p3=new Point(6,12);
		 r.setPointC(p3);
		 Point p4=new Point(7,9);
		 r.setPointD(p4);
		 return r;
	 }
	
}
