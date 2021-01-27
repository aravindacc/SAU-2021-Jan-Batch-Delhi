package com.au2021.Controller;

import com.au2021.Service.C_Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import java.io.IOException;
import org.json.simple.JSONObject;
//import org.json.JSONException;

import javax.servlet.ServletException;

@Controller
public class C_Controller {

    private final C_Service calculatorService = new C_Service();

    @RequestMapping(value = "/calculator",method = RequestMethod.GET)
    public String homeCalculatorPage() {
        return "calculator";
    }

    @RequestMapping(value = "/calculator", method = RequestMethod.POST)
    public String handleCalculation(ModelMap model, @RequestParam String num1, @RequestParam String num2, @RequestParam String operator) throws Exception {

        if(num1 == null || num2==null || operator== null){
            throw new ServletException("Mandatory Input Missing!");
        }

        if(operator.equals("/") && num2.equals("0")) {
            JSONObject obj=new JSONObject();
            obj.put("Operator:","Divide");
            obj.put("Message", "divide by zero throws arithmetic exception");
            model.put("msg", obj);
            System.out.println(obj);
            return "ArithmeticExceptionPage";
        }

        int result = calculatorService.calculate(num1, num2, operator);
        if(result>1000) {
            throw new IOException("Large Result value! (Expected value < 1000)");
        }
        else {
            model.put("num1", num1);
            model.put("num2", num2);
            model.put("result", result);
            return "ResultPage";
        }
    }

    @ExceptionHandler(value=IOException.class)
    public String handleLargeNumberException(Exception e) {
        return "LargeNumberPage";
    }

    @ExceptionHandler(value=Exception.class)
    public String handleGenericException(Exception e) {
        return "GenericErrorPage";
    }
}