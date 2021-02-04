package com.spring.au;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class Rectangle {

    public Rectangle() {
        super();
    }
   public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
       return point2;   }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public Point getPoint3() {
        return point3;
    }

    public void setPoint3(Point point3) {
        this.point3 = point3;
    }

    public Point getPoint4() {
        return point4;
    }

    public void setPoint4(Point point4) {
        this.point4 = point4;
    }

    @Autowired
    @Qualifier("Point1")
    private Point point1;

    @Autowired
    @Qualifier("Point2")
    private Point point2;

    @Autowired
    @Qualifier("Point3")
    private Point point3;

    @Autowired
    @Qualifier("Point4")
    private Point point4;

    public void draw() {
        System.out.println(getPoint1().getX()+","+getPoint1().getY());
        System.out.println(getPoint2().getX()+","+getPoint2().getY());
        System.out.println(getPoint3().getX()+","+getPoint3().getY());
        System.out.println(getPoint4().getX()+","+getPoint4().getY());
    }

   

}
