package com.groupeisi.web;

import com.groupeisi.wsdl.GetInfoRequest;
import com.groupeisi.wsdl.GetInfoResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class M2GLEndpoint {
    @PayloadRoot(namespace = "http://ws.groupeisi.com", localPart = "getInfoRequest")
    public @ResponsePayload GetInfoResponse getInfoResponse(@RequestPayload GetInfoRequest request){
        GetInfoResponse response = new GetInfoResponse();
        response.setOutput("Bonjour M2GL " + request.getInput());
        return response;
    }
}
