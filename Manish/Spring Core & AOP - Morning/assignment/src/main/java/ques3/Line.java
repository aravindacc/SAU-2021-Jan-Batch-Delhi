package ques3;

import java.util.List;

public class Line {
    List<Integer> points;

    public List<Integer> getPoints() {
        return points;
    }

    public void setPoints(List<Integer> points) {
        this.points = points;
    }

    public String getPointsAsString() {
        return points.toString();
    }

    public void  tryExp() {
        double x = 1/0;
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
