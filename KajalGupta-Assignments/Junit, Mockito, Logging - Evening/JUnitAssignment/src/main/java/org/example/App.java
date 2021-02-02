package org.example;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;


public class App 
{
    public static int add(int a, int b)
    {
        logger.info("Inside add function");
        return a+b;
    }

    public static int subtract(int a, int b)
    {
        logger.info("Inside subtract function");
        return a-b;
    }
    static Logger logger = (Logger)LogManager.getLogger(App.class);

    public static void main( String[] args )
    {
        BasicConfigurator.configure();
        logger.info("Entering application.");

        System.out.println("Sum of 3 and 4 is: "+add(3,4));
        System.out.println("Difference of 3 and 4 is: "+subtract(3,4));
    }
}
