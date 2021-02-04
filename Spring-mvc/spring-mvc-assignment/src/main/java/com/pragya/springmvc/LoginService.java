package com.pragya.springmvc;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	 public int calculate(String firstNumber,
             String secondNumber,
             String operator) {
		 
  int a = Integer.parseInt(firstNumber);
  int b = Integer.parseInt(secondNumber);

switch (operator) {
case "ADD":
 return a+b;
case "SUBSTRACT":
 return a-b;
case "MULTIPLY":
 return a * b;
case "DIVIDE":
 return a / b;
default:
 return -1;
}
}
}
