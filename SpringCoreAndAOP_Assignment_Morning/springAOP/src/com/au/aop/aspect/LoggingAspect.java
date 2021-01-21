package com.au.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import com.au.aop.model.Circle;

@Aspect
public class LoggingAspect {

	public void loggingAdvice(JoinPoint joinpoint)
    {
        System.out.println("Run Advice..... get method Executed");
        System.out.println(joinpoint.toString());
        Circle c=(Circle)joinpoint.getTarget();
        System.out.println(c.getName());
    }
   
    @AfterReturning(pointcut="args(name)",returning="returnString")
    public void allStringMethodArguments(String name, String returnString){
    System.out.println("A setter method has been executed............"+name);
    }
   
    @AfterThrowing(pointcut="args(name)",throwing="ex")
    public void exceptionAdvice(String name, Exception ex){
    System.out.println("Exception is thrown ............"+ex);
    }
   
    @After("args(String)")
    public void afterAdvice(){
    System.out.println("After Advice is executed...........");
    }

    @Pointcut("execution(*  get*())")
    public void allGetters(){}
   
   
    @Around("allGetters()")
    public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint)
    {
        Object returnValue=null;
            try {
                System.out.println("Before method Executed");
                returnValue=proceedingJoinPoint.proceed();
                System.out.println("After Method Executed....");
            } catch (Throwable e) {
                System.out.println("Around Advice throws exception");
        }
        System.out.println("After Finally executed........");
               
        return returnValue;
    }
}
