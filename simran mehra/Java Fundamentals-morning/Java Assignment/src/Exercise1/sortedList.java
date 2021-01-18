package Exercise1;

import java.util.*;
import java.util.Scanner;

public class sortedList {
	public static void main(String[] args) {
	    int n;
	    int num;

	    List<Integer> arrList = new ArrayList<Integer>();

	    Scanner sc = new Scanner(System.in);
	    System.out.print("Enter the total number of elements in arraylist: ");

	    num = sc.nextInt();
	    System.out.print("Enter the numbers: ");
	    for (int i = 0; i < num; i++) {
	        n = sc.nextInt();
	        arrList.add(n);
	    }

	    Collections.sort(arrList);
	    System.out.println("Sorted ArrayList : "+ arrList);
	}

		
		
}
