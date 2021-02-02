package com.company;
import java.util.*;

public class question1 {
    public static void main(String[] args){
        System.out.println("Queston 1 -> Write a Java program to print the sorted list of integers by using one of the collection set");
        ArrayList<Integer> arr=new ArrayList<Integer>();
        Scanner sc= new Scanner(System.in);
        System.out.println("Number Count");
        int n=sc.nextInt();
        System.out.println("Enter the number");
        for(int i=0;i<n;i++){
            arr.add(sc.nextInt());
        }
        System.out.println(arr);
    }
}
