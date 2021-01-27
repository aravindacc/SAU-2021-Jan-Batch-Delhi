package com.au2021;

import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;

public class ExceptionHandler extends SimpleMappingExceptionResolver {

    @Override
    public String buildLogMessage(Exception e, HttpServletRequest request) {
        return "Error : " + e.getLocalizedMessage();
    }
}