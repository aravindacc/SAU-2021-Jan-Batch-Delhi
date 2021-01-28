import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;


//1. Write a Java program to print the sorted list of integers by using one of the collection set

public class JavaAssignmentQues1 {
	
	public static void main(String args[]) 
    { 
		//Create an empty vector   
	    Vector<Integer> vec = new Vector<Integer>();  
	    
	    @SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
	    System.out.println("Enter the size of the integer vector:");
	    int vectorSize=input.nextInt();
	   
	    System.out.println("Enter the elements in vector:");
	    int element;
	
	    while(vec.size()<vectorSize){
	        element= input.nextInt();
	        vec.add(element); 
	    }
	
	    System.out.println("Elements of the vector: "+vec);        
	    //Sorting the vector  
	    Collections.sort(vec);  
	    //Displaying the vector elements after sort() method  
	    System.out.println("Elements of the vector after sorting: "+vec);                             
    }  
}
