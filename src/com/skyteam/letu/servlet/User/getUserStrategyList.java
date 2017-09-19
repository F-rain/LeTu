package com.skyteam.letu.servlet.User;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.skyteam.letu.entities.Strategy;
import com.skyteam.letu.server.impl.UserManageImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "getUserStrategyList", value = "/getMyStrategyList")
public class getUserStrategyList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Strategy> strategyList = null;
        if (request.getParameter("UserID") != null){
            strategyList = new UserManageImpl().getStrategyList(request.getParameter("UserID"));

        }

        response.setCharacterEncoding("UTF-8");
        response.setContentType("TEXT/JSON");

        response.getWriter().write(new Gson().toJson(strategyList == null?new JsonObject():strategyList));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
