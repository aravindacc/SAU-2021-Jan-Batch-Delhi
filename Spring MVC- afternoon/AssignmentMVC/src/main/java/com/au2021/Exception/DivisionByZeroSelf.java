package com.au2021.Exception;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.HashMap;

@ControllerAdvice
public class DivisionByZeroSelf extends Exception{

    //private Log logger = LogFactory.getLog(DivisionByZeroSelf.class);

    public DivisionByZeroSelf()
    {
        super("Division by zero");
    }

    @RequestMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    @ExceptionHandler(value = DivisionByZeroSelf.class)
    public @ResponseBody
    HashMap<String, String> handleError(HttpServletRequest req, Exception exception) {
        HashMap<String,String> obj=new HashMap<>();
        obj.put("Operation","/");
        obj.put("Message","Divide By Zero");
        return obj;
    }
}
