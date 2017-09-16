package com.fx.service.impl;

import com.fx.entity.request.Request;
import com.fx.entity.response.Response;
import com.fx.service.CalculateService;

public class LPService implements CalculateService {
    @Override
    public Response calculate(Request result) {
        Response response = new Response();
        response.code = "20";
        return response;
    }
}
