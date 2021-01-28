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
public class MathApplicationTester {

    MathApplication mathApp = new MathApplication();

    @Mock
    CalculatorService calService;

    @Test
    public void testAdd(){
        lenient().when(calService.add(20.0, 20.0)).thenReturn(40.0);
        Assert.assertEquals(mathApp.add(20.0, 20.0),40.0,0);

    }

    @Test
    public void testSubstract(){
        lenient().when(calService.subtract(40.0, 30.0)).thenReturn(10.0);
        Assert.assertEquals(mathApp.subtract(40.0, 30.0),10.0,0);
    }
    @Test
    public void testMultiply(){
        lenient().when(calService.multiply(20.0, 20.0)).thenReturn(400.0);
        Assert.assertEquals(mathApp.multiply(20.0, 20.0),400.0,0);
    }

    @Test
    public void testDivide(){
        lenient().when(calService.divide(70.0, 10.0)).thenReturn(7.0);
        Assert.assertEquals(mathApp.divide(70.0, 10.0),7.0,0);
    }
}