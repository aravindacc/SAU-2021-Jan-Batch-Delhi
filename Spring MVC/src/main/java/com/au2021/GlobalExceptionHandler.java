package com.au2021;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ModelAndView NANException(HttpServletRequest request, Exception ex){
        
    	ModelAndView mV = new ModelAndView();
        
        mV.addObject("exception", "Please Enter Integers Only!");
        mV.addObject("url", request.getRequestURL());

        mV.setViewName("GenericException");
        return mV;
    }
    
    @ExceptionHandler(IOException.class)
    public ModelAndView LargeResultException(HttpServletRequest request, Exception ex){
        ModelAndView mV = new ModelAndView();
        mV.addObject("exception", "The result is greater than 1000");
        mV.addObject("url", request.getRequestURL());

        mV.setViewName("LargeNumber");
        return mV;
    }
    
}

