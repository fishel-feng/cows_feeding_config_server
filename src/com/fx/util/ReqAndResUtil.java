package com.fx.util;

import com.fx.entity.request.Request;
import com.fx.entity.response.Response;
import com.fx.service.CalculateService;
import com.google.gson.Gson;
import com.mathworks.toolbox.javabuilder.MWException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ReqAndResUtil {

    public static void makeRes(HttpServletRequest request, HttpServletResponse response, CalculateService calculateService) throws IOException {
        Request result = new Gson().fromJson(StringIOUtil.readRequest(request.getReader()), Request.class);
        Response end = null;
        try {
            end = calculateService.calculate(result);
        } catch (MWException e) {
            e.printStackTrace();
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        String jsonStr = new Gson().toJson(end);
        PrintWriter out = response.getWriter();
        out.write(jsonStr);
        out.close();
    }
}
