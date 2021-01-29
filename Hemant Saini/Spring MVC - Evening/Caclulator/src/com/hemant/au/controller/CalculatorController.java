package com.hemant.au.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hemant.au.service.CalculatorService;

@Controller
public class CalculatorController {
	
	@Autowired
    CalculatorService calculatorService ;
	
	@RequestMapping(value = "/calculator", method = RequestMethod.GET)
    public String openCalculator(){
        return "calculator";
    }

    @RequestMapping(value = "/calculator", method = RequestMethod.POST)
    public String calculate (@RequestParam String firstNumber, @RequestParam String secondNumber,@RequestParam String operation, ModelMap model) throws Exception{
        int result = calculatorService.performOperation(firstNumber, secondNumber , operation);
        model.put("result", result);
        return "result";
    }
    
    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public String calculateResult(@RequestParam String result, ModelMap model){
        model.put("result", result);
        return "result";
    }
    
}
