package junit_mockito;

public class MathApplication {
	
	public double add(double input1, double input2){
	      return input1 + input2;
	   }
	   
	   public double subtract(double input1, double input2){
	      return input1 - input2;
	   }
	   
	   public double multiply(double input1, double input2){
	      return input1 * input2;
	   }
	   
	   public double divide(double input1, double input2) throws ArithmeticException{
		   if(input2 == 0 && input1 != 0 )
		   		throw new ArithmeticException();
		   return  input1 / input2;
	   }
	
	
	
}
