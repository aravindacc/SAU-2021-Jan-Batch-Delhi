package ques3;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logging {

    //After, AfterReturning, AfterThrowing, Around advices in AOP.
    @After("execution(public * get*())")
    public void LogGetters() {
        System.out.println("After Getter invoked");
    }

    @AfterReturning("execution(public * get*())")
    public void LogReturns() {
        System.out.println("Function invoked successfully");
    }

    @AfterThrowing(("execution(public * try*())"))
    public void LogExceptions() {
        System.out.println("Exception occurred");
    }

    @Around("execution(public * getPointsAsString())")
    public void LogCalls() {
        System.out.println("Around called");
    }

}
