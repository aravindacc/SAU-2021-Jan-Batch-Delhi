package main.java;

import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;



@RunWith(MockitoJUnitRunner.class)
public class MathApllicationTester {

   MathApplication mathApplication = new MathApplication();

   @Mock
   CalculatorService calcService;

   @Test
   public void testAdd(){
	  lenient().when(calcService.add(10.0, 20.0)).thenReturn(30.0);
      Assert.assertEquals(mathApplication.add(10.0, 20.0),30.0,0);
      
   }
   
   @Test
   public void testSubstract(){
       lenient().when(calcService.subtract(30.0, 20.0)).thenReturn(10.0);
	      Assert.assertEquals(mathApplication.subtract(30.0, 20.0),10.0,0);
	   }
   @Test
   public void testMultiply(){
       lenient().when(calcService.multiply(10.0, 20.0)).thenReturn(200.0);
	      Assert.assertEquals(mathApplication.multiply(10.0, 20.0),200.0,0);
	   }
   
   @Test
   public void testDivide(){
       lenient().when(calcService.divide(50.0, 10.0)).thenReturn(5.0);
	      Assert.assertEquals(mathApplication.divide(50.0, 10.0),5.0,0);
	   }
}