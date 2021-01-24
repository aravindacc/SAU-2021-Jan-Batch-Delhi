package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean(name="pointObject")
    public Point getPoint() {
        return new Point(1,1);
    }
	
    @Bean(name="triangleObject")
    public Triangle getTriangle() {
        return new Triangle(4,3);
    }

    @Bean(name="rectangleObject")
    public Rectangle getRectangle() {
        return new Rectangle();
    }

    @Bean(name="Point1")
    public Point getPoint1() {
        return new Point(1,1);
    }

    @Bean(name="Point2")
    public Point getPoint2() {
        return new Point(5,1);
    }

    @Bean(name="Point3")
    public Point getPoint3() {
        return new Point(5,5);
    }

    @Bean(name="Point4")
    public Point getPoint4() {
        return new Point(1,5);
    }

}

