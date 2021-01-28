package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class Triangle {

    private int width;
    private int height;

    @Autowired
    @Qualifier("Point1")
    private Point point1;

    @Autowired
    @Qualifier("Point2")
    private Point point2;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Autowired
    @Qualifier("Point3")
    private Point point3;

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public Point getPoint3() {
        return point3;
    }

    public void setPoint3(Point point3) {
        this.point3 = point3;
    }

    @Autowired
    public Triangle() {

    }

    @Autowired
    public Triangle(Point point1, Point point2, Point point3, int height, int width) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.height = height;
        this.width = width;
    }

    public Triangle(int a, int b){
        this.height = a;
        this.width = b;
    }

    public void draw(){
        System.out.println("Drawing triangle with points :");
        System.out.println("("+point1.getPointX()+","+point1.getPointY()+")");
        System.out.println("("+point2.getPointX()+","+point2.getPointY()+")");
        System.out.println("("+point3.getPointX()+","+point3.getPointY()+")");
        System.out.println("Height of triangle is : "+getHeight());
        System.out.println("Width of triangle is : "+getWidth());
    }
}
