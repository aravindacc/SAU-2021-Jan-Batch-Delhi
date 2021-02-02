package ques4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class Rectangle {

    @Autowired @Qualifier("point1")
    Point p1;

    @Autowired @Qualifier("point2")
    Point p2;

    @Autowired @Qualifier("point3")
    Point p3;

    @Autowired @Qualifier("point4")
    Point p4;

    @Override
    public String toString() {
        return "Rectangle{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                ", p3=" + p3 +
                ", p4=" + p4 +
                '}';
    }
}
