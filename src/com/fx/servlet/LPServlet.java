package com.fx.servlet;

import com.fx.service.impl.LPService;
import com.fx.util.ReqAndResUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LPServlet", urlPatterns = "/LP")
public class LPServlet extends javax.servlet.http.HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        ReqAndResUtil.makeRes(request, response, new LPService());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }
}
