package com.au.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
//import org.aspectj.lang.annotation.Pointcut;

//multiple advices inside aspect
@Aspect
@Component
public class LoggingAspect {
	
	@Before("execution(public String getName())")
    public void LoggingAdviceBefore() {
        System.out.println("Logging Advice : Before");

    }
	
	@After("execution(public String getName())")
	public void LoggingAdviceGetters() {
		System.out.println("Logging Advice : After");
	}

	@AfterReturning("execution(public String getName())")
	public void LogAfterReturning() {
		System.out.println("Logging Advice: After Returning");
	}

	@AfterThrowing("execution(public void throwsException())")
	public void LogAfterThrowing() {
		System.out.println("Logging Advice: After Throwing");
	}

	@Around("execution(public String getName())")
	public void LogAroundAllGeters(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("Before Advice: Around");
		try {
			joinPoint.proceed();
		} finally {
			System.out.println("After Advice: Around");
		}
		
	}


}
