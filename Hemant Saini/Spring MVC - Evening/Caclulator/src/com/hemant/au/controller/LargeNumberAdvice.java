package com.hemant.au.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class LargeNumberAdvice extends Exception{
	
	 public LargeNumberAdvice() {
		 super();
	 }
	 
	 @ExceptionHandler(value = LargeNumberAdvice.class)
	 @ResponseBody
	 public ModelAndView handleLargeNumberError() {
		 ModelAndView modelAndView = new ModelAndView();
	     modelAndView.addObject("error", "Large Number Error : number > 1000");
	     modelAndView.setViewName("largeNumberError");
         return modelAndView;
	 }
}
