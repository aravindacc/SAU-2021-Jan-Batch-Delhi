package com.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

import org.json.simple.JSONObject;  

@Controller
public class HomeController {

	private HomeService homeService = new HomeService();
	
	@RequestMapping(value = "/home",method = RequestMethod.GET)
	
	public String showLoginPage() {
		return "home";
	}
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String handleUserLogin(ModelMap model, @RequestParam String firstNum,
			@RequestParam String secondNum, @RequestParam String operator)
					throws Exception {
		
	
        if(firstNum.isBlank() || secondNum.isBlank()) {
      	  throw new NumberFormatException("Input is wrong");
        }
	       
         //Zero exception 
		if(operator.equals("DIVIDE") && secondNum.equals("0")) {
			JSONObject obj=new JSONObject();    
			  obj.put("operation","/");
			  obj.put("message", "divide by zero");
			  model.put("msg", obj);
			  System.out.println(obj);
			  return "NullPointerException";
		}
		
	
		int result = homeService.calculate(firstNum, secondNum, operator);
		
		//Greater than zero
		if(result>1000) {
			throw new IOException("Large Output");
		}
		
		else {
		model.put("firstNumber", firstNum);
		model.put("secondNumber", secondNum);
		model.put("result", result);
		return "result";
		}
	}
	
	
	@ExceptionHandler(value=IOException.class)
	public String handleNullPointException(Exception e) {
		return "LargeNumber";
	}
	
	
	@ExceptionHandler(value=Exception.class)
	public String handleGenericException(Exception e) {
		return "GenericError";
	}
}
