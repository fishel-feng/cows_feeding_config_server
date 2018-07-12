package com.fx.servlet;

import com.fx.service.impl.ThreeTypeGeneticService;
import com.fx.util.ReqAndResUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ThreeTypeGeneticServlet", urlPatterns = "/ThreeTypeGeneticServlet")
public class ThreeTypeGeneticServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReqAndResUtil.makeRes(request, response, new ThreeTypeGeneticService());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
