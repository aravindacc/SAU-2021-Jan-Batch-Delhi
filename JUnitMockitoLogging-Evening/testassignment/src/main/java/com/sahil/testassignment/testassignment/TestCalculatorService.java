package com.sahil.testassignment.testassignment;

import static org.mockito.Mockito.lenient;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class TestCalculatorService{
	
	CalculatorApplication calculatorApplication;
	
	// Subtraction and Division test is done with Mockito Object
	CalculatorService calculatorService = Mockito.mock(CalculatorService.class);;

	@Before
	public void setUp() {
		System.out.println("Starting Testing...");
		calculatorApplication = new CalculatorApplication(calculatorService);
		
	}
	
	
	// Simple JUnit test
	@Test
	public void testAddition(){
	      Assert.assertEquals(calculatorApplication.add(70.0, 80.0),150.0,0);     
	      Assert.assertEquals(calculatorApplication.add(50.0, 120.0),170.0,0);
	}
	
	
	// JUnit test with Mockito
	@Test
	public void testSubtraction(){
		  lenient().when(calculatorService.subtractTwoNumber(80.0, 70.0)).thenReturn(10.0);
	      Assert.assertEquals(calculatorApplication.subtract(80.0, 70.0),10.0,0);
	      
	      lenient().when(calculatorService.subtractTwoNumber(90.0, 60.0)).thenReturn(30.0);
	      Assert.assertEquals(calculatorApplication.subtract(90.0, 60.0),30.0,0);
	      
	      
	}
	
	
	// Simple JUnit test
	@Test
	public void testMultiplication(){
		
	      Assert.assertEquals(calculatorApplication.multiply(70.0, 80.0),5600.0,0);
	      Assert.assertEquals(calculatorApplication.multiply(50.0, 120.0),6000.0,0);
	}
	
	
	//JUnit test with Mockito
	@Test
	public void testDivision(){
		  lenient().when(calculatorService.divideTwoNumber(70.0, 10.0)).thenReturn(7.0);
	      Assert.assertEquals(calculatorApplication.divide(70.0, 10.0),7.0,0);
	      
	      lenient().when(calculatorService.divideTwoNumber(500.0, 50.0)).thenReturn(10.0);
	      Assert.assertEquals(calculatorApplication.divide(500.0, 50.0),10.0,0);
	}
	 
	@After
	public void setDown() {
		System.out.println("Ending Testing...");
	}
	
	
}