package com.au2021.Exception;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class DivideByZeroException extends Exception {

    public DivideByZeroException() {
        super("Divide by zero is not allowed");
    }

    @ResponseBody
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ExceptionHandler(value = DivideByZeroException.class)
    public Map<String, String> handleDivideByZero() {
        Map<String, String> jsonMap = new HashMap<>();
        jsonMap.put("Operation", "Divide");
        jsonMap.put("Symbol", "/");
        jsonMap.put("Message", "Divide By Zero is not allowed");
        jsonMap.put("Suggestion", "Do not use zero for b");
        return jsonMap;
    }
}