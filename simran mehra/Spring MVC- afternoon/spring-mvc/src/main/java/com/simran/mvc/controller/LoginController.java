package com.simran.mvc.controller;

import com.simran.mvc.exception.CustomExceptionHandler;
import com.simran.mvc.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

import static com.simran.mvc.exception.CustomExceptionHandler.handleArithmeticException;

@Controller
public class LoginController {
    LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String handleUserLogin(ModelMap model, @RequestParam String firstNum,
                                  @RequestParam String secondNum, @RequestParam String operator) throws Exception {
        int a,b;
        try {
            if (firstNum.isEmpty() || (secondNum.isEmpty())) {
                throw new Exception();
            }
            a = Integer.parseInt(firstNum);
            b = Integer.parseInt(secondNum);
        } catch (Exception e) {
            throw new NumberFormatException("Input is wrong");
        }
        int result;
        try {
            result = loginService.calculate(a, b, operator);
        } catch (ArithmeticException e) {
            return handleArithmeticException(model);
        }
        
        if (result > 1000) {
            throw new IOException("Greater than 1000");
        } else {
            model.put("name", firstNum);
            model.put("sname", secondNum);
            model.put("oname", result);
            return "welcome";
        }
    }
}
