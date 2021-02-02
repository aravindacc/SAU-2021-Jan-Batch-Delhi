package ques2;

import java.util.List;

public class Line {
    List<Integer> points;

    public List<Integer> getPoints() {
        return points;
    }

    public void setPoints(List<Integer> points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Line{" +
                "pointsDis=" + points +
                '}';
    }
}
