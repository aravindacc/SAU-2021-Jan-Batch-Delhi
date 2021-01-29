package com.hemantMathServiceTest.au.MockitoTester;

import com.hemantMathsService.au.service.MathsOperationsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TestMathOperationServiceMockito {
    @Mock
    MathsOperationsService mathsOperationsService;

    @Test
    public void testAddMockito(){

        when(mathsOperationsService.add(10,20)).thenReturn(30);
        when(mathsOperationsService.add(20,30)).thenReturn(50);

        assertEquals(mathsOperationsService.add(10,20),30);
        assertEquals(mathsOperationsService.add(20,30),50);
        assertNotEquals(mathsOperationsService.add(20,30), 60);

        //Failing TestCase just trying
        //assertNotEquals(mathsOperationsService.add(20,30), 50);
        verify(mathsOperationsService,atLeast(1)).add(10,20);
    }

    @Test
    public void testSubtractMockito(){

        when(mathsOperationsService.subtract(10,20)).thenReturn(-10);
        when(mathsOperationsService.subtract(40,30)).thenReturn(10);

        assertEquals(mathsOperationsService.subtract(10,20),-10);
        assertNotEquals(mathsOperationsService.subtract(10,20),10);
        assertEquals(mathsOperationsService.subtract(40,30),10);

        verify(mathsOperationsService,atLeast(2)).subtract(10,20);
    }

    @Test
    public void testMultiplyMockito(){

        when(mathsOperationsService.multiply(10,20)).thenReturn(200);
        when(mathsOperationsService.multiply(20,30)).thenReturn(600);

        assertEquals(mathsOperationsService.multiply(10,20),200);
        assertEquals(mathsOperationsService.multiply(20,30),600);

        verify(mathsOperationsService,atLeast(1)).multiply(10,20);
    }

    @Test
    public void testDivideMockito(){

        when(mathsOperationsService.divide(20,20)).thenReturn(1.0);
        when(mathsOperationsService.divide(2100,300)).thenReturn(7.0);

        assertEquals(mathsOperationsService.divide(20,20),1.0, 0.001);
        assertEquals(mathsOperationsService.divide(2100,300),7.0, 0.001);
        assertNotEquals(mathsOperationsService.divide(20, 20), 1);

        //Failing TestCase
        //assertNotEquals(mathsOperationsService.add(20,30), 50);
        verify(mathsOperationsService,atLeast(2)).divide(20,20);
    }
}
