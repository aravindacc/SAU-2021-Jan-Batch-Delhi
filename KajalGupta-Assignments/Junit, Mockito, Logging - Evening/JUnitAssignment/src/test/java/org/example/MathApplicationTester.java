package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {

    //@InjectMocks annotation is used to create and inject the mock object
    @InjectMocks
    MathApplication mathApplication = new MathApplication();

    //@Mock annotation is used to create the mock object to be injected
    @Mock
    CalculatorService calcService;

    @Test
    public void test(){

        //testing add
        when(calcService.add(10.0,20.0)).thenReturn(30.00);
        Assert.assertEquals(calcService.add(10.0, 20.0),30.0,0);
        verify(calcService).add(10.0, 20.0);

        //testing subtract
        when(calcService.subtract(10.0,20.0)).thenReturn(-10.00);
        Assert.assertEquals(calcService.subtract(10.0, 20.0),-10.0,0);
        verify(calcService).subtract(10.0, 20.0);


        //testing subtract
        when(calcService.multiply(10.0,20.0)).thenReturn(200.00);
        Assert.assertEquals(calcService.multiply(10.0, 20.0),200.0,0);
        verify(calcService).multiply(10.0, 20.0);


        //testing subtract
        when(calcService.divide(20.0,10.0)).thenReturn(1.00);
        Assert.assertEquals(calcService.divide(20.0, 10.0),1.0,0);
        verify(calcService).divide(20.0, 10.0);


    }
}