package com.hemant.au.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class DivideByZeroAdvice extends Exception{
	public DivideByZeroAdvice() {
        super();
	}
	
    @ExceptionHandler(value = DivideByZeroAdvice.class)
    @ResponseBody
    public ModelAndView handleDivideByZeroError() {
		ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error", "Divide by Zero Error; Do Not Enter 0 as second number");
        modelAndView.setViewName("divideByZeroError");
        return modelAndView;
    }
}
