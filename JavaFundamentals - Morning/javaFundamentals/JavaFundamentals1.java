package javaFundamentals;
import java.util.*;

public class JavaFundamentals1
{
	public static void main(String args[])  
	{  
	//creating an object of ArrayList class  
	ArrayList<Integer> list = new ArrayList<Integer>();  
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter number of input: ");
	int n = sc.nextInt();
	int m;
	System.out.println("Enter integrs to sort: ");
	for (int i = 0; i<n; i++)
	{
		m = sc.nextInt();
		list.add(m);
	}
	
	//printing ArrayList before sorting  
	System.out.println("ArrayList Before Sorting:");  
	for(int marks: list)  
	{  
	System.out.println(marks);  
	}  
	//sorting ArrayList in descending order  
	 Collections.sort(list, Collections.reverseOrder());  
	//printing ArrayList after sorting  
	System.out.println("ArrayList After Sorting:");  
	for(int marks: list)  
	{  
	System.out.println(marks);  
	}  
	}  

}
