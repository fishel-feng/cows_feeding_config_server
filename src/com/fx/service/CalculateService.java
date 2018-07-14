package com.fx.service;

import com.fx.entity.request.Request;
import com.fx.entity.response.Response;
import com.mathworks.toolbox.javabuilder.MWException;

public interface CalculateService {

    Response calculate(Request result) throws MWException;
}
