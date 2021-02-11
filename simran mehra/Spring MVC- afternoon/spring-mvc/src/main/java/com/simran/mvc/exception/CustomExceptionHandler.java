package com.simran.mvc.exception;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler {
    public static String handleArithmeticException(ModelMap model) {
        Map<String, Object> msg = new HashMap<>();
        msg.put("operation", "/");
        msg.put("message", "divide by zero");
        model.put("msg", msg);
        System.out.println(msg);
        return "NullPointerException";
    }

    @ExceptionHandler(value = IOException.class)
    public String handleNullPointException(Exception e) {
        return "LargeNumber";
    }

    @ExceptionHandler(value = Exception.class)
    public String handleGenericException(Exception e) {
        return "GenericError";
    }
}