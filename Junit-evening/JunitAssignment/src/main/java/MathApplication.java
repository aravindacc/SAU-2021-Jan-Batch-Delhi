package main.java;

public class MathApplication {
//	private CalculatorService calcService;
//	
//	
//	 public void setCalculatorService(CalculatorService calcService){
//	      this.calcService = calcService;
//	   }
	   
	   public double add(double first, double second){
	      return first+second;
	   }
	   
	   public double subtract(double first, double second){
	      return first-second;
	   }
	   
	   public double multiply(double first, double second){
	      return first*second;
	   }
	   
	   public double divide(double first, double second) throws ArithmeticException{
		   if(second==0 && first != 0 )
		   		throw new ArithmeticException();
		   return  first/second;
	   }
	
}
