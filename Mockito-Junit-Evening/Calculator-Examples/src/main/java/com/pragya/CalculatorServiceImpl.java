package com.pragya;

public class CalculatorServiceImpl implements Calculator {
	@Override
	public int addition(int num1, int num2) {
		System.out.println("**--- AddServiceImpl add executed ---**");
		return num1 + num2;
	}

	@Override
	public int subtraction(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1-num2;
	}

	@Override
	public int multiplication(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1 * num2;
	}

	@Override
	public int division(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1/num2;
	}
}
