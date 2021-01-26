package com.sahil.springmvc;

import org.springframework.stereotype.Service;
import org.springframework.expression.spel.ast.Operator;
import java.math.*;

@Service
public class InputService {
	
	public int calculate(String firstNumber,
			String secondNumber,
			String operator) {

		int numberA = Integer.parseInt(firstNumber);
		int numberB = Integer.parseInt(secondNumber);

		switch (operator) {
		case "ADD":
			return numberA + numberB;
		case "SUBSTRACT":
			return numberA - numberB;
		case "MULTIPLY":
			return numberA * numberB;
		case "DIVIDE":
			return numberA / numberB;
		default:
			return -1;
		}
	}
}

