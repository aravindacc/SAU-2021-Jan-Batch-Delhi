package ques2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext factory = new ClassPathXmlApplicationContext("ques2.xml");
        Line line = (Line) factory.getBean("line");
        System.out.println(line);
    }
}
