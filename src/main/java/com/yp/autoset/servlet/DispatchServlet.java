package com.yp.autoset.servlet;


import com.alibaba.fastjson.JSONObject;
import com.yp.autoset.annotation.AutoSet;
import com.yp.autoset.config.ScanAnnotation;
import com.yp.autoset.controller.TestController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet
public class DispatchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        System.out.println("servlet开始");
        try{
//            ScanAnnotation scanAnnotation = new ScanAnnotation();
//            scanAnnotation.getMapping(req.getRequestURI(), req.getParameterMap());
            ScanAnnotation.getMapping(req.getRequestURI(), req.getParameterMap());
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("映射执行方法错误");
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
