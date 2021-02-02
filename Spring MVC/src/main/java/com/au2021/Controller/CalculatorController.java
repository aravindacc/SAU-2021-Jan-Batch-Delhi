package com.au2021.Controller;

import com.au2021.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class CalculatorController {

    @Autowired
    CalculatorService calcService ;


    @RequestMapping(value = "/enter", method = RequestMethod.POST)
    public String handleLoginRequest(@RequestParam String a, @RequestParam String b,
                                     @RequestParam String operation, ModelMap model) throws Exception{

        boolean isValidNumber = calcService.isInputValid(a ,b) ;
        
        if(!isValidNumber){
            throw new IllegalArgumentException() ;
        }
        
        int result;
        int num1 = Integer.parseInt(a) ;
        int num2 = Integer.parseInt(b) ;

		if(operation=="add"){
			result = num1 + num2 ;
			if(result > 1000){
				 throw new IOException() ;
			}
		}
		else if(operation=="sub"){
			result = num1 - num2 ;
			if(result > 1000){
				 throw new IOException() ;
			}
		}
		else if(operation=="mul"){
			result = num1 * num2 ;
			if(result > 1000){
				 throw new IOException() ;
			}
		}
		else if(operation=="div"){
			result = num1 / num2 ;
			if(result > 1000){
				 throw new IOException() ;
			}
		}
		else result=0;
		
        model.put("result", result);

        return "Result";
    }



    @RequestMapping(value = "/Result", method = RequestMethod.GET)
    public String getResult(@RequestParam String result, ModelMap model){
        model.put("result", result);
        return "Result";
    }

    @ExceptionHandler(ArithmeticException.class)
    public ModelAndView DivideByZeroException(HttpServletRequest request, Exception ex){
        
    	ModelAndView mV = new ModelAndView();
        
        String error = " { Operation : '/' , message : 'Divide by Zero'} " ;
        
        mV.addObject("exception", error);
        mV.addObject("url", request.getRequestURL());


        mV.setViewName("divideByZero");
        return mV;
    }


}
