import java.util.Scanner;

public class divide {

	public static void divideNumbers(int dividend, int divisor) throws ArithmeticException{
		if(divisor==0)
		    throw new ArithmeticException();

		else
		    System.out.println("\nQuotient : "+ (float) dividend / divisor);
    	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nEnter the Dividend : ");
		int dividend = scanner.nextInt();
		System.out.print("\nEnter the Divisor : ");
		int divisor = scanner.nextInt();
		try{
		    divideNumbers(dividend, divisor);
		}
		catch(ArithmeticException e){
		    System.out.println("\nDivide by Zero Exception");
		}
	}

}
