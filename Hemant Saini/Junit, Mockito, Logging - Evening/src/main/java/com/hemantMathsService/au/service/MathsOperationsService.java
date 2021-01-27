package com.hemantMathsService.au.service;

public class MathsOperationsService {
    public int add(int firstNumber, int secondNumber){ return (firstNumber + secondNumber); }

    public int subtract(int firstNumber, int secondNumber){
        return (firstNumber - secondNumber);
    }

    public int multiply(int firstNumber, int secondNumber){
        return (firstNumber * secondNumber);
    }

    public double divide(double firstNumber, double secondNumber) throws ArithmeticException{
        return (firstNumber / secondNumber);
    }
}
