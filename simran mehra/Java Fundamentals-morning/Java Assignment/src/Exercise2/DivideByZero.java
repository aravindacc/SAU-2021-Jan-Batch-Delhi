package Exercise2;
import java.util.Scanner;

public class DivideByZero {
	static void divide(int a, int b) throws ArithmeticException {
		if(b==0)
			throw new ArithmeticException();
		else
			System.out.println((float)a/b);
		
	}
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		System.out.println("Enter the numbers: ");
		int n1= scan.nextInt();
		int n2= scan.nextInt();
//		divide(n1,n2);
		try {
			divide(n1, n2);
		}catch(Exception e){
			System.out.println("Dividing by Zero exception");
		}
		
	}
}
