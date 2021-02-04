package pragya.Code;

public class ExceptionTest {

	static void checkDivisibility(int number) {
		if(number<=0) {
			throw new ArithmeticException("Number can't be divisible by 0");
		}
		else {
			int result = 100/number;
			System.out.print("100 is divisible by " +number+" and result is "+result);
		}
	}
	
	public static void main(String[] args)throws ArithmeticException {
		// TODO Auto-generated method stub
		
		System.out.println(" check divisibility !!");
		
		checkDivisibility(0);
		
		System.out.println("Exception Handle");
	}

}

