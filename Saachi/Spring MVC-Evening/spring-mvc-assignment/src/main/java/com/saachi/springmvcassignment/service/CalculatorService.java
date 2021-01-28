package com.saachi.springmvcassignment.service;

import org.springframework.expression.spel.ast.Operator;
import org.springframework.stereotype.Service;
import java.math.*;

@Service
public class CalculatorService {
	 public int calculate(String firstNumber, String secondNumber, String operator) {
		 
	     int a = Integer.parseInt(firstNumber);
	     int b = Integer.parseInt(secondNumber);

	     switch (operator) {
                case "+":
                 return a+b;
                case "-":
                 return a-b;
                case "*":
                 return a * b;
                case "/":
                 return a / b;
                default:
                 return -1;
            }
	 }
}
