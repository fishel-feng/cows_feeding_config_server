package com.fx.servlet;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "LPServlet",urlPatterns = "/LP")
public class LPServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
