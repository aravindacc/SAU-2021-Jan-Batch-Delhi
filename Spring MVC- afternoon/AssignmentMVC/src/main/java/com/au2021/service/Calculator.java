package com.au2021.service;


import com.au2021.Exception.DivisionByZeroSelf;
import com.au2021.Exception.LargeNumberException;
import org.springframework.stereotype.Service;

@Service
public class Calculator {
	public int calculate(String firstNum, String secondNum,String operation)  throws Exception {
		int result=0;
		
		if(operation.equals("addition"))
		{
			result= Integer.parseInt(firstNum)+Integer.parseInt(secondNum);

		}
		if(operation.equals("substraction"))
		{
			result= Integer.parseInt(firstNum)-Integer.parseInt(secondNum);
		}
		if(operation.equals("multiply"))
		{
			result= Integer.parseInt(firstNum)*Integer.parseInt(secondNum);
		}
		if(operation.equals("divide"))
		{
			if(Integer.parseInt(secondNum)==0)
			{
				throw new DivisionByZeroSelf();
			}
			result= Integer.parseInt(firstNum)/Integer.parseInt(secondNum);
		}
		return result;
	}

}