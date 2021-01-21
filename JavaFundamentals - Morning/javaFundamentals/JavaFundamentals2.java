package javaFundamentals;
import java.io.*;

public class JavaFundamentals2
{
	static void checkEligibilty(int stuage, int stuweight){ 
	      if(stuage<12 && stuweight<40) {
	         throw new ArithmeticException("Student is not eligible for registration"); 
	      }
	      else {
	         System.out.println("Student Entry is Valid!!"); 
	      }
	   } 

	   public static void main(String args[]) throws IOException{ 
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     System.out.println("Welcome to the Registration process!!");
	     System.out.println("Enter Student age and weight");
	     int age = Integer.parseInt(br.readLine());
	     int weight = Integer.parseInt(br.readLine());
	     checkEligibilty(age, weight); 
	     System.out.println("Have a nice day.."); 
	 } 
}
