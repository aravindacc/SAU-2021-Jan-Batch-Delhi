package Nipun;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class tester {
    @InjectMocks
    calculator calc= new calculator();
    @Mock
    services service;
    @Test
    public void testAdd(){
        when(service.add(150.0,130.0)).thenReturn(500.00);
        Assert.assertEquals(calc.add(320.0, 300.0),500.0,0);
    }
    public void testSubtract() {
        when(service.subtract(90.0,80.0)).thenReturn(35.00);
        Assert.assertEquals(calc.subtract(9050.0, 520.0),120.0,0);
    }
    public void testMultiply() {
        when(service.multiply(95.0,86.0)).thenReturn(600.00);
        Assert.assertEquals(calc.multiply(910.0, 710.0),600.00,0);
    }
    public void testDivide() {
        when(service.divide(20.0,10.0)).thenReturn(30.00);
        Assert.assertEquals(calc.divide(20.0, 10.0),2.0,0);
    }
}