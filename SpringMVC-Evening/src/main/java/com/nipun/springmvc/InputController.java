package com.sahil.springmvc;

import org.json.simple.JSONObject;  
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ExceptionHandler;


@Controller
public class InputController {

	private InputService loginService = new InputService();
	
	@RequestMapping(value = "/input",method = RequestMethod.GET)
	public String showLoginPage() {
		return "Input here";
	}
	
	
	@ExceptionHandler(value=Exception.class)
	public String handleGenericException(Exception e) {
		return "Generic Error";
	}
	
	@ExceptionHandler(value=IOException.class)
	public String handleNullPointException(Exception e) {
		return "LargeNumber";
	}
	
	@RequestMapping(value = "/input", method = RequestMethod.POST)
	public String handleUserLogin(ModelMap model, @RequestParam String firstNum,
			@RequestParam String secondNum, @RequestParam String operator)
					throws Exception {
		
	
        if(firstNum.isBlank() || secondNum.isBlank()) {
      	  throw new NumberFormatException("Wrong input here");
        }
	       
       
		if(operator.equals("DIVIDE") && secondNum.equals("0")) {
			JSONObject obj=new JSONObject();    
			  obj.put("operation",'/');
			  obj.put("message", "You are dividing by Zero");
			  model.put("msg", obj);
			  System.out.println(obj);
			  return "NullPointerException";
		}
		
	
		int result = loginService.calculate(firstNum, secondNum, operator);
		
		
		if(result>1000) {
			throw new IOException("Large output");
		}
		
		else {
		model.put("name", firstNum);
		model.put("sname", secondNum);
		model.put("oname", result);
		return "result";
		}
	}
	
}

