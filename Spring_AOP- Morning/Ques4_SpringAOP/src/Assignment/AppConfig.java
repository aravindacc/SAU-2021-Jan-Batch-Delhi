package Assignment;

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
		return new Triangle("Equilateral", 1, 10);
	}
	
	@Bean(name="PointA")
	public Point getPointA() {
		return new Point(11,20);
	}
	@Bean(name="PointB")
	public Point getPointB() {
		return new Point(21,30);
	}
	@Bean(name="PointC")
	public Point getPointC() {
		return new Point(31,40);
	}
	@Bean(name="PointD")
	public Point getPointD() {
		return new Point(41,50);
	}

}
