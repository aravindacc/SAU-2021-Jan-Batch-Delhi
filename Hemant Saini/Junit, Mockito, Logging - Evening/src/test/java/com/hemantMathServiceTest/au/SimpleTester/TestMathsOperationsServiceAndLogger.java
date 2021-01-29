package com.hemantMathServiceTest.au.SimpleTester;

import com.hemantMathsService.au.service.MathsOperationsService;
import junit.framework.TestCase;
import org.junit.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestMathsOperationsServiceAndLogger extends TestCase {

    private MathsOperationsService mathsOperationsService;
    private static final Logger LOGGER = LogManager.getLogger(TestMathsOperationsServiceAndLogger.class);
    private int a, b;
    public void setUp(){
        mathsOperationsService = new MathsOperationsService();
        a = 40;
        b = 20;
    }

    //I have written @Test annotation for clarity
    //With extends TestCase it is not required.
    @Test
    public void testAdd() {

        int expectedResult = 60;
        int result = mathsOperationsService.add(a, b);
        LOGGER.info("Result of Addition : " + result);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSubtract() {
        int expectedResult = 20;
        int result = mathsOperationsService.subtract(a, b);
        LOGGER.info("Result of Subtraction : " + result);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testMultiply() {
        long expectedResult = 800;
        long result = mathsOperationsService.multiply(a, b);
        LOGGER.info("Result of Multiplication : " + result);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testDivide() {
        double expectedResult = 2.0;
        double result = mathsOperationsService.divide(a, b);
        LOGGER.info("Result of Division : " + result);
        assertEquals(expectedResult, result,0.00005);
    }
}
