package ques4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean("point1")
    public Point getPoint1() {
        return new Point(0,0);
    }

    @Bean("point2")
    public Point getPoint2() {
        return new Point(5,0);
    }

    @Bean("point3")
    public Point getPoint3() {
        return new Point(5,5);
    }

    @Bean("point4")
    public Point getPoint4() {
        return new Point(0,5);
    }

    @Bean
    public Rectangle getRectangle() {
        return new Rectangle();
    }
}
