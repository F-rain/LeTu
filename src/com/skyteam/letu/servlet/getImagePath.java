package com.skyteam.letu.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.skyteam.letu.dao.impl.ImageDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "getImagePath", value = "/getImagePath")
public class getImagePath extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> imagePathList = null;
        if(request.getParameter("type") != null && request.getParameter("ID") != null){
            imagePathList = new ImageDaoImpl().getImagePath(request.getParameter("type"), request.getParameter("ID"));
        }

        response.setCharacterEncoding("UTF-8");
        response.setContentType("TEXT/JSON");

        response.getWriter().write(new Gson().toJson(imagePathList == null?new JsonObject():imagePathList));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
