package com.skyteam.letu.servlet.Strategy;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.skyteam.letu.entities.Strategy;
import com.skyteam.letu.server.impl.StrategyManageImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 获取单条攻略
 * Created by rick- on 2017/6/22.
 */
@WebServlet(name = "getStrategy", value = "/getStrategy")
public class getStrategy extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Strategy strategy = null;

        if (request.getParameter("StrategyID") != null && request.getParameter("Status") != null){
            strategy = new StrategyManageImpl().getStrategy(request.getParameter("StrategyID"), Integer.parseInt(request.getParameter("Status")));

        }

        response.setContentType("TEXT/JSON");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(strategy == null?new JsonObject():strategy));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
