package org.tempuri;

public class TestWS {

		public static void main(String [] args)
		{
			int a=7;
			int b=3;
			Calculator cal=new Calculator();
			CalculatorSoap soap=cal.getCalculatorSoap();
			int add=soap.add(a, b);
			System.out.println(add);
		}
}
