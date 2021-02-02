//Java program to print the sorted list of integers by using one of the collection set
import java.lang.*;
import java.util.*;
import java.io.*; 
public class ArrayListSort
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Please Input the size of List");
		
		int n;
		n=sc.nextInt();
		
		List<Integer> arr=new ArrayList<Integer>();
		
		int a;
		
		System.out.println("Please provide input List");
		
		for(int i=0;i<n;i++){
		    a=sc.nextInt();
		    arr.add(a);
		}
		
		Collections.sort(arr);
		
		System.out.println("Sorted List is -");
		
		for(int i=0;i<n;i++){
		    System.out.print(arr.get(i)+" ");
		}

	}
}
