package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the elements in array. Press q to exit.");
        String s;

        do{
            s = in.nextLine( );
            if(s.equals("q"))
            {
                break;
            }
            else
            {
                list.add(Integer.parseInt(s));
            }
        }while(!s.equals("q"));


        Collections.sort(list);


        System.out.println("List after the use of Collection.sort() :\n" + list);
    }
}
