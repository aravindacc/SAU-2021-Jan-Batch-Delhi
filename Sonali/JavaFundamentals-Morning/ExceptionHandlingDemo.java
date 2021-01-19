import java.util.*;

public class ExceptionHandlingDemo{
	
	static void checkEligibility(int age, int weight)  throws ArithmeticException { 
	      
			if(age<12 && weight<40) 
	         throw new ArithmeticException("Student is not eligible for registration."); 
	      
	      else 
	         System.out.println("Student Entry is Valid!!"); 
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to the Registration process!!");
		System.out.println("Enter Your Age :");
		int age = in.nextInt(); 
		System.out.println("Enter Your Weight :");
		int weight = in.nextInt(); 
		try {
		checkEligibility(age,weight);
		}
		catch(ArithmeticException e)
		{
			//System.out.println(e);
			e.printStackTrace();
		}
		finally {
			System.out.println("Thank You!!"); 
		}
		
	}
	
}