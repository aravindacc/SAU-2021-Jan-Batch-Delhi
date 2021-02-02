package Niket;

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
        when(service.add(20.0,30.0)).thenReturn(50.00);
        Assert.assertEquals(calc.add(20.0, 30.0),50.0,0);
    }
    public void testSubtract() {
        when(service.subtract(40.0,20.0)).thenReturn(20.00);
        Assert.assertEquals(calc.subtract(20.0, 20.0),20.0,0);
    }
    public void testMultiply() {
        when(service.multiply(30.0,20.0)).thenReturn(600.00);
        Assert.assertEquals(calc.multiply(30.0, 20.0),600.00,0);
    }
    public void testDivide() {
        when(service.divide(20.0,10.0)).thenReturn(30.00);
        Assert.assertEquals(calc.divide(20.0, 10.0),2.0,0);
    }
}