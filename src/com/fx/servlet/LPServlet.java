package com.fx.servlet;

import com.fx.entity.request.Request;
import com.fx.entity.response.Response;
import com.fx.service.CalculateService;
import com.fx.service.impl.LPService;
import com.fx.util.StringIOUtil;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LPServlet", urlPatterns = "/LP")
public class LPServlet extends javax.servlet.http.HttpServlet {

    private CalculateService calculateService = new LPService();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Request result = new Gson().fromJson(StringIOUtil.readRequest(request.getReader()), Request.class);
        Response end = calculateService.calculate(result);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        String jsonStr = new Gson().toJson(end);
        PrintWriter out = response.getWriter();
        out.write(jsonStr);
        out.close();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }
}
