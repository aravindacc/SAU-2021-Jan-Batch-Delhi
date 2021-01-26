package com.au.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


@Aspect
public class LoggingAspect 
{

	@Around("execution(* com.au.aop.model.Circle.getName())")
	public void aroundAdvice()
	 { 
		
		System.out.println("Around Advice");
	}
	
	
	
	@After("execution(* com.au.aop.model.Triangle.setName(..))")
	public void afterAdvice() 
	{
		System.out.println("After Advice");
		
	}

	@AfterThrowing(pointcut = "execution(* com.au.aop.model.Circle.setName(..))" ,
	 throwing = "error")
	public void afterThrowingAdvice( Throwable error ) {
		System.out.println("After Throwing Advice");
		
	}
	
	
	
	@AfterReturning(pointcut = "execution(* com.au.aop.model.Triangle.getName(..))" ,
	 returning = "name")
	public void afterReturningAdvice(String name ){
		System.out.println("After Return Advice");
		
	}

}