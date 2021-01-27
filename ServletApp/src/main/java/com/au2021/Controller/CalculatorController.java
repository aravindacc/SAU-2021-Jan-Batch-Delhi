package com.au2021.Controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class CalculatorController {

   


    @RequestMapping(value = "/enter", method = RequestMethod.POST)
    public String handleLoginRequest(@RequestParam String input1,
                                    @RequestParam String input2,
                                     @RequestParam String operation, 
                                     ModelMap model) throws Exception{

       

        int num1 = Integer.parseInt(input1) ;
        int num2 = Integer.parseInt(input2) ;

        int ans =0;

     
            if(operation == "multiply"){
            ans = num1 * num2 ;
            if(ans > 1000){
                throw new IOException() ;
            }
            break ;}





            
            if(operation == "sub"){
                         ans = num1 - num2 ;
                        if(ans > 1000){
                            throw new IOException() ;
                        }
                        break ;}
            

                        if(operation == "add"){
                            ans=num1+num2;
                        if(ans > 1000){
                             throw new IOException() ;
                        }
                        break ;}



           
                        if(operation == "divide"){
                        if(num2 == 0){
                            throw new ArithmeticException() ;
                        }
                        ans = num1 / num2 ;
                        if(ans > 1000){
                            throw new IOException() ;
                        }
                        break ;}
           
    

        model.put("ans", ans);

        return "Answer";
    }



    @RequestMapping(value = "/Answer", method = RequestMethod.GET)
    public String getResult(@RequestParam String result, ModelMap model){
        model.put("answer", result);
        return "Answer";
    }

    @ExceptionHandler(ArithmeticException.class)
    public ModelAndView handleDivideByZeroException(
        HttpServletRequest request, Exception ex){
        ModelAndView modelAndView = new ModelAndView();
        String error = " { Operation : '/' , message : 'Division by 0 is not defined'} " ;
        modelAndView.addObject("exception", error);
        modelAndView.addObject("url", request.getRequestURL());


        modelAndView.setViewName("DivisionByZeroNotAllowed");
        return modelAndView;
    }

}
