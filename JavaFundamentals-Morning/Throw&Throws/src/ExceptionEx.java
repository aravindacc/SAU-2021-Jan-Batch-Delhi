import java.util.*;
public class ExceptionEx {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the numbers to be divided:");
		int n1 = scn.nextInt();
		int n2 = scn.nextInt();
		   try{
		      findException(n1,n2);
		    }
		  catch(ArithmeticException e) {
			  System.out.println(e.getMessage());
		  }

		  }
	

	private static void findException(int n1, int n2) throws ArithmeticException {
		if (n2==0) {
			throw new ArithmeticException("Trying to divide by 0");
		}
		else 
			System.out.print("Answer is" +" "+ n1/n2);
		
	}

}
