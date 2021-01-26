package com.simran.mvc.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public int calculate(int firstNumber, int secondNumber, String operator) {
        switch (operator) {
            case "ADD":
                return firstNumber + secondNumber;
            case "SUBSTRACT":
                return firstNumber - secondNumber;
            case "MULTIPLY":
                return firstNumber * secondNumber;
            case "DIVIDE":
                final int result;
                try{
                    result = firstNumber / secondNumber;
                }catch(Exception e){
                    throw new ArithmeticException();
                }
                return result;
            default:
                return -1;
        }
    }
}
