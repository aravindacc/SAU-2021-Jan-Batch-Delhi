package com.sahil.testassignment.testassignment;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LogFile {

	private static final Logger LOGGER =LogManager.getLogger(LogFile.class);
	private static CalculatorApplication calcObj = new CalculatorApplication();

	
	private static void calculate(double numberOne, double numberTwo) {
		
		System.out.println("Calculating inside logger: "+calcObj.add(numberOne,numberTwo));
		LOGGER.info(numberOne + " + "+numberTwo+" = " + calcObj.add(numberOne,numberTwo) );
		LOGGER.info(numberOne + " * "+numberTwo+" = " + calcObj.multiply(numberOne,numberTwo) );

		
	}
	
	public static void main(String[] args) {
		LOGGER.error("Logger has been Set Up Successfullyyyyy......");
		
		LOGGER.info("HY");
		LOGGER.fatal("This is fatal");
		LOGGER.info("please");
		
		calculate(100.0, 50.0);
	}
}
