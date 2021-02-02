package Proj;

public class calculator {
	private services service;



	//Adding different calculator services

	   public void setCalculatorService(services service){
	      this.service = service;
	   }
	   //Add Service Added
	   public int add(int num1, int num2){
	      return service.add(num1, num2);
	   }
	   //Subtract Service Added
	   public int subtract(int num1, int num2){
	      return service.subtract(num1, num2);
	   }
	    //Multiply  Service Added
	   public int multiply(int num1, int num2){
	      return service.multiply(num1, num2);
	   }
	    //Divide Service Added
	   public int divide(int num1, int num2){
	      return service.divide(num1, num2);
	   }
}
