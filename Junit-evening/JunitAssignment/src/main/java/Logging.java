package main.java;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;

public class Logging {
	private static final Logger logger=LogManager.getLogger(Logging.class);

	private static MathApplication ma= new MathApplication();
	
	private static void calc(double first,double second)
	{
		logger.info("Addition of "+first + " and "+second+" is " + ma.add(first,second) );

		logger.info("subtraction of "+first + " and "+second+" is " + ma.subtract(first,second) );

		logger.info("Multiplication of "+first + " and "+second+" is " + ma.multiply(first,second) );

		try {
			logger.info("Division of " + first + " and " + second + " is " + ma.divide(first, second));
		}
		catch (Exception e)
		{
			logger.error("Exception  " + e);
		}
	}
	
	
	public static void main(String args[])
	{
		//PropertyConfigurator.configure("log4j2.xml");
		BasicConfigurator.configure();
		calc(1.0,0.0);
	}
}
