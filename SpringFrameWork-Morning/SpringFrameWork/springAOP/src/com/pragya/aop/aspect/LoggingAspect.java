package com.pragya.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	
	
	@After("execution(* com.pragya.aop.model.*.get*(..))")
	public void LoggingAdviceGetters() {
		System.out.println("After");
	}

	@AfterReturning("execution(* com.pragya.aop.model.*.set*(..))")
	public void LogAfterReturning() {
		System.out.println("After Return");
	}

	@AfterThrowing("execution(* com.pragya.aop.model.*.throwExceptionDemo())")
	public void LogAfterThrowing() {
		System.out.println("After Throw");
	}

	@Around("execution(public * getClassName())")
	public void LogAroundAllGetters(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("Around All getters");
		try {
			joinPoint.proceed();
		} finally {
			System.out.println("Inside finally block");
		}
		
	}

}
