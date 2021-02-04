package com.pragya;

import java.util.logging.LogManager;
import java.util.logging.Logger;
import com.pragya.CalculatorServiceImpl;

public class logging {
	
	private static final Logger logger=LogManager.getLogger(Logger.class);

	private static CalculatorServiceImpl c= new CalculatorServiceImpl();
	
	private static void calc(int num1,int num2)
	{
		logger.info("Addition of "+num1 + " and "+num2+" is " + c.addition(num1,num2) );

		logger.info("subtraction of "+num1 + " and "+num2+" is " + c.subtraction(num1,num2) );

		logger.info("Multiplication of "+num1 + " and "+num2+" is " + c.multiplication(num1,num2) );

		try {
			logger.info("Division of " + num1+ " and " + num2 + " is " + c.division(num1,num2));
		}
		catch (Exception e)
		{
			((Object) logger).error("Exception  " + e);
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicConfigurator.configure();
		calc(10,20);
	}
	}


