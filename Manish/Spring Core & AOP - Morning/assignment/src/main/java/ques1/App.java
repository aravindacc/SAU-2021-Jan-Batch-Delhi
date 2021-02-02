package ques1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext factory = new ClassPathXmlApplicationContext("ques1.xml");

        // Set
        WithSet setObj = (WithSet) factory.getBean("withSet");
        System.out.println(setObj);

        // Map
        WithMap mapObj = (WithMap) factory.getBean("withMap");
        System.out.println(mapObj);
    }
}
