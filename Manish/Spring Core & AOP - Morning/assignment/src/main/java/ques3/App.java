package ques3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext factory = new ClassPathXmlApplicationContext("ques3.xml");
        Line line = (Line) factory.getBean("line");
        System.out.println(line);
        line.getPoints();
        line.getPointsAsString();

        // just to create exception
        line.tryExp();
    }

}
