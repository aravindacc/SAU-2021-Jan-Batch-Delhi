import java.util.Collections;
import java.util.Vector;
import java.util.Scanner;



public class Question1 {
	
	public static void main(String args[]) 
    { 
		
	    Vector<Integer> inputList = new Vector<Integer>();  
	    
		Scanner scannerInput = new Scanner(System.in);
		
	    System.out.println("Enter List Size: ");
	    int inputSize = scannerInput.nextInt();
	   
	    System.out.println("Enter the elements in vector:");
	    while(inputList.size() < inputSize)
	        inputList.add(scannerInput.nextInt()); 
	    
	
	    System.out.println("Input Elements are: " + inputList);          
	    
	    //	SORTING
	    Collections.sort(inputList);  
	      
	    System.out.println("Sorted List: " + inputList);
	    
	    scannerInput.close();
    }  
}