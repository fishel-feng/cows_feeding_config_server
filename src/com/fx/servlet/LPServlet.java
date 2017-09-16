package com.fx.servlet;

import com.fx.entity.request.Request;
import com.fx.entity.response.Response;
import com.fx.service.CalculateService;
import com.fx.service.impl.LPService;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LPServlet", urlPatterns = "/LP")
public class LPServlet extends javax.servlet.http.HttpServlet {

    private CalculateService calculateService = new LPService();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        BufferedReader br = request.getReader();
        String str;
        StringBuilder wholeStr = new StringBuilder();
        while ((str = br.readLine()) != null) {
            wholeStr.append(str);
        }
        Request result = new Gson().fromJson(wholeStr.toString(), Request.class);
        Response end = calculateService.calculate(result);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        String jsonStr = new Gson().toJson(end);
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.write(jsonStr);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }
}
