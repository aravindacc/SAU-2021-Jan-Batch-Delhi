import java.util.Scanner; 

public class Question2 {
	
	// for generating in-built exception
	public static void calculate(int num, int den) throws ArithmeticException
	{		
		System.out.println("Result: " + num / den);
	}
	
	// for generating custom exception
	public static void checkEligibility(int age) throws ArithmeticException
	{
		if(age < 18)
	         throw new ArithmeticException("Not Eligible to Vote"); 

		
	     else 
	         System.out.println("You are eligible to Vote."); 
	}
	
	public static void main(String args[])
	{
		System.out.println("Generating In-built Exception");
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter Numerator: ");		
		int numerator = input.nextInt();
		
		System.out.println("\nEnter Denominator(Enter 0 to get exception): ");
		int denominator = input.nextInt();
		
		try
		{
			calculate(numerator, denominator);
		}
		catch(ArithmeticException e)
		{
			System.out.println("Exception generated using throws: " + e);
		}
		
		
		
		System.out.println("\n \n Generating Custom Exception");
		System.out.println("Enter age(Enter less than 18 to get exception): ");
			
		int age = input.nextInt();
		
		try
		{
			checkEligibility(age);
		}
		catch(ArithmeticException e)
		{
			System.out.println("Custom Error generated: "+ e);
		}
		
		input.close();
	}

}
