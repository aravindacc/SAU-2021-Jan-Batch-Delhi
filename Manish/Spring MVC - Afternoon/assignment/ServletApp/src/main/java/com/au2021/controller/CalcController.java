package com.au2021.controller;

import com.au2021.Exception.DivideByZeroException;
import com.au2021.Exception.LargeNumberException;
import com.au2021.service.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalcController {

    @Autowired
    CalcService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loadCalc() {
        return "calc";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String calcValue(@RequestParam String a, @RequestParam String b, @RequestParam String opr, ModelMap modelMap) throws LargeNumberException, DivideByZeroException {
        int res = service.calc(a, b, opr);
        if (res > 1000) throw new LargeNumberException();
        modelMap.put("result", res);
        return "result";
    }
}
