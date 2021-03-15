package com.au2021.Exception;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@ControllerAdvice
public class LargeNumberException extends Exception{

    public LargeNumberException(){
        super("Large Number Error");
    }

    @ExceptionHandler(value = LargeNumberException.class)
    public ModelAndView handleError(HttpServletRequest req, Exception exception) {
        ModelAndView mv=new ModelAndView();
        System.out.println(exception);
        mv.addObject("exception",exception);
        mv.addObject("url",req.getRequestURL());
        mv.setViewName("division_error");
        return mv;
    }
}
