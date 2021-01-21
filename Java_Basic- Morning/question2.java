package com.company;
import java.util.Scanner;
public class question2 {
    static void divide(int n ) throws ArithmeticException{
        if(n==0){
            throw new ArithmeticException("Divide by zero Error");
        }
        System.out.println(10/n);
    }
    public static void main(String[] args){
        System.out.println("Question 2 -> Write a Java program to throw arithmetic exception using “throw” and “throws”");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number");
        int n=sc.nextInt();
        divide(n);
    }
}
