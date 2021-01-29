package com.hemant.au.resolver;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpRequest;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;


public class ExceptionResolver extends SimpleMappingExceptionResolver {

	@Override
	public String buildLogMessage(Exception exception, HttpRequest request) {
        return ("Exception: " + exception.getLocalizedMessage());
    }
}