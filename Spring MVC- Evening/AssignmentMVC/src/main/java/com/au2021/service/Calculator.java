package com.au2021.service;


import org.springframework.stereotype.Service;
import com.au2021.Exception.DivisionByZero;
import com.au2021.Exception.LargeNumberException;

@Service
public class Calculator {

	public int calculate(String firstNumber, String secondNumber,String operation) throws DivisionByZero {

		Integer number1 = Integer.parseInt(firstNumber);
		Integer number2 = Integer.parseInt(secondNumber);
		Integer result = 0;

		switch (operation){

			case "add":
				result = number1 + number2;
				break;
			case "substract":
				result = number1 - number2;
				break;
			case "multiply":
				result = number1 * number2;
				break;
			case "divide":
				if(number2 == 0)
					throw new DivisionByZero();
				result = number1 / number2;
				break;

		}
		return result;
	}

}