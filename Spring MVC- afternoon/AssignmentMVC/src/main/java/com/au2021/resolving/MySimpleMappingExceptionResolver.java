package com.au2021.resolving;


import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;

public class MySimpleMappingExceptionResolver extends
        SimpleMappingExceptionResolver {

    @Override
    public String buildLogMessage(Exception ex, HttpServletRequest request) {
        return "Spring MVC exception: " + ex.getLocalizedMessage();
    }
}
