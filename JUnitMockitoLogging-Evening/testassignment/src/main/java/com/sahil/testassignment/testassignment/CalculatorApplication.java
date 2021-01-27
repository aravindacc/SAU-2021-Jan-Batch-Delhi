package com.sahil.testassignment.testassignment;


public class CalculatorApplication {

	CalculatorService calculatorService;
	
	public CalculatorApplication() {
		
	}
	
	public CalculatorApplication(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}
	
	//For Simple JUnit Test
	public double add(double numberOne, double numberTwo) {
		return (numberOne + numberTwo);
	}
	
	// For JUnit with Mockito Test
	public double subtract(double numberOne, double numberTwo) {
		return calculatorService.subtractTwoNumber(numberOne, numberTwo);
	}
	
	// For Simple JUnit Test
	public double multiply(double numberOne, double numberTwo) {
		return (numberOne * numberTwo);
	}
	
	// For JUnit with Mockito Test
	public double divide(double numberOne, double numberTwo) throws ArithmeticException{
		
		if(numberTwo == 0)
			throw new ArithmeticException();
		
		return calculatorService.divideTwoNumber(numberOne, numberTwo);
	}
}
