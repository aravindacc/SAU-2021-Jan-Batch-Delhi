package com.pragya.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.pragya.CalcService;
import com.pragya.Calculator;

public class CalcServiceTest {

	CalcService calcService;

	@Mock
	private Calculator calculator;

	@BeforeEach
	public void setup() {
		System.out.println("@BeforeEach CalcServiceTest");
		MockitoAnnotations.initMocks(this);
		
	}

	@Test
	public void testCalcAdd() {
		System.out.println("**--- Test testCalcAdd executed ---**");

		calcService = new CalcService(calculator);

		int num1 = 11;
		int num2 = 12;
		int expected = 23;

		when(calculator.addition(num1, num2)).thenReturn(expected);

		int actual = calcService.calcAdd(num1, num2);

		assertEquals(expected, actual);

	}
	@Test
	public void testCalcSub() {
		System.out.println("**--- Test testCalcSub executed ---**");

		calcService = new CalcService(calculator);

		int num1 = 10;
		int num2 = 5;
		int expected = 5;

		when(calculator.subtraction(num1, num2)).thenReturn(expected);

		int actual = calcService.calcSub(num1, num2);

		assertEquals(expected, actual);

	}
	
	@Test
	public void testCalcMul() {
		System.out.println("**--- Test testCalcMul executed ---**");

		calcService = new CalcService(calculator);

		int num1 = 10;
		int num2 = 20;
		int expected = 200;

		when(calculator.multiplication(num1, num2)).thenReturn(expected);

		int actual = calcService.calcMul(num1, num2);

		assertEquals(expected, actual);

	}
	
	@Test
	public void testCalcDiv() {
		System.out.println("**--- Test testCalcDiv executed ---**");

		calcService = new CalcService(calculator);

		int num1 = 10;
		int num2 = 5;
		int expected = 2;

		when(calculator.division(num1, num2)).thenReturn(expected);

		int actual = calcService.calcDiv(num1, num2);

		assertEquals(expected, actual);

	}
}
