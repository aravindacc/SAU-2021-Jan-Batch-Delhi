package com.hemant.au.service;

import org.springframework.stereotype.Service;

import com.hemant.au.controller.DivideByZeroAdvice;
import com.hemant.au.controller.LargeNumberAdvice;

@Service
public class CalculatorService {
	public int performOperation(String firstNumberStr, String secondNumberStr, String operation) throws Exception {

        Integer firstNumber = Integer.parseInt(firstNumberStr);
        Integer secondNumber = Integer.parseInt(secondNumberStr);
        Integer result;

        switch (operation){

            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if(secondNumber == 0)
                    throw new DivideByZeroAdvice();
                result = firstNumber / secondNumber;
                break;
            default:
            	result = 0;
            	break;

        }
        if(result>1000)
            throw new LargeNumberAdvice();
        return result;
    }
}
