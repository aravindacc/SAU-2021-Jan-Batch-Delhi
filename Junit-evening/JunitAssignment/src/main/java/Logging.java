package main.java;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;

public class Logging {
	private static final Logger logger=LogManager.getLogger(Logging.class);

	private static MathApplication mathapp= new MathApplication();
	
	private static void calculate(double num1,double num2)
	{
		logger.info("Addition of "+num1 + " and "+num2+" is " + mathapp.add(num1,num2) );

		logger.info("subtraction of "+num1 + " and "+num2+" is " + mathapp.subtract(num1,num2) );

		logger.info("Multiplication of "+num1 + " and "+num2+" is " + mathapp.multiply(num1,num2) );

		try {
			logger.info("Division of " + num1 + " and " + num2 + " is " + mathapp.divide(num1, num2));
		}
		catch (Exception er)
		{
			logger.error("Exception is " + er);
		}
	}
	
	
	public static void main(String args[])
	{

		BasicConfigurator.configure();
		calculate(5.0,0.0);
	}
}
