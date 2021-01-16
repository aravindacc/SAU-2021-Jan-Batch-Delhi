import java.lang.String;
import java.util.Scanner; 

//2. Write a Java program to throw arithmetic exception using “throw” and “throws”2. Write a Java program to throw arithmetic exception using “throw” and “throws”

@SuppressWarnings("serial")
class JavaAssignmentQues2 extends Exception{
	
	@SuppressWarnings("null")
	static void PredefinedExceptionExample(int num, int denominator) throws ArithmeticException,NullPointerException,StringIndexOutOfBoundsException
	{
			System.out.println("random int :" + num);
				int numenator = num, Denominator = denominator; 
					if(Denominator==0)
					{
						throw new ArithmeticException();	// cannot divide by zero 
					}
					else
					{
						System.out.println("Result of Division :" + numenator/denominator);
					}
				
	    		String line= "This is like you.";  
            	char index = line.charAt(num); 
	            	if(num>=line.length())
					{
						throw new StringIndexOutOfBoundsException();	// index out of bounds
					}
					else
					{
						System.out.println("Character at index "+ num+ " of the string : "+ index);
					}
			 	
            	String line_2 = null; 			//null value 
            	System.out.println(line_2.charAt(0));   	 
	}

	
	static void CustomExceptionExample(int age) throws ArithmeticException{ 
	      if( age<18) {
	         throw new ArithmeticException("Person not eligible for driving license"); 
	      }
	      else {
	         System.out.println("Eligible for Driving License!"); 
	      }
	} 
	
	public static void main(String args[]) throws ArithmeticException
    { 
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);  // Create a Scanner object
		
		System.out.println("Enter 1 for Predefined Exception example.\nEnter 2 for Custom Exception example.\nEnter your Choice:");
		int choice = input.nextInt(); 
		
		switch(choice)
		{
		
				case 1: {
							// Read user input
						    System.out.print("Enter an integer: ");
						    int number = input.nextInt();
						    System.out.print("Enter an integer (for denominator): ");
						    int denominator = input.nextInt();
						    try {
						    		PredefinedExceptionExample(number, denominator);
						    	}
							catch(ArithmeticException e) { 			
					           		System.out.println("Catches Arthimetic Exception : can't divide by zero"); 
								}
						    catch(StringIndexOutOfBoundsException e) {    
					           		System.out.println("Catches String Index OutOfBounds Exception"); 
					        	}
							catch(NullPointerException e) { 			
									System.out.println("Catches Null pointer Exception"); 
								}
							catch(Exception e) { 			
									System.out.println("Catches any exception under superclass exception!"); 
								}
							break;
						}
				
				case 2: {
						 	System.out.print("Enter age of person to check for driving license eligiblity: ");
						    int age= input.nextInt(); 
						  
						    try {
						    	CustomExceptionExample(age);
						    }
						    catch(ArithmeticException e) { 			
				           		System.out.println("Catches Arthimetic Exception: Person not eligible for driving license"); 
							}
						}
		}
	}
}
