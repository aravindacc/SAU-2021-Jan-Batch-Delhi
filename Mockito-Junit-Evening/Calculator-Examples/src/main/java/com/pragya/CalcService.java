package com.pragya;

public class CalcService {
	
	private Calculator calculator;
	
	public CalcService(Calculator calculator) {
		this.calculator = calculator;
	}

	public int calcAdd(int num1, int num2) {
		System.out.println("**--- CalcService calcAdd executed ---**");
		return calculator.addition(num1, num2);
	}
   
	public int calcSub(int num1, int num2) {
		System.out.println("**--- CalcService calcSub executed ---**");
		return calculator.subtraction(num1, num2);
	}
	
	public int calcMul(int num1, int num2) {
		System.out.println("**--- CalcService calcMul executed ---**");
		return calculator.multiplication(num1, num2);
	}
	
	public int calcDiv(int num1, int num2) {
		System.out.println("**--- CalcService calcDiv executed ---**");
		return calculator.division(num1, num2);
	}
}
