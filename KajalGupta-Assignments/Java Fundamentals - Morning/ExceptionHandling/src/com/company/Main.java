package com.company;

import java.util.Scanner;

public class Main {

    static void divideNumbers(int number1, int number2) throws ArithmeticException
    {
        if(number2==0){
            throw new ArithmeticException();
        }
        else{
            System.out.println("Result is : "+ (float) number1/number2);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two numbers to divide them");
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();
        try
        {
            divideNumbers(number1, number2);
        }
        catch(Exception e)
        {
            System.out.println("Divide by zero exception");
        }
    }

}
