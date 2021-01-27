package com.assignment.endpoint;

import com.assignment.resultgenrator.Acknowledgement;
import com.assignment.resultgenrator.StudentRequest;
import com.assignment.service.ResultGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ResultGeneratorEndpoint {

    private static final String NAMESPACE="http://www.assignment.com/resultgenrator";

    @Autowired
    private ResultGeneratorService service;

    @PayloadRoot(namespace = NAMESPACE,localPart = "StudentRequest")
    @ResponsePayload
    public Acknowledgement getResultStatus(@RequestPayload StudentRequest request){
        return service.getResult(request);
    }


}

