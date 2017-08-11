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
import java.util.List;

/**
 * 获取攻略列表
 * Created by rick- on 2017/6/22.
 */
@WebServlet(name = "getStrategyList", value = "/getStrategyList")
public class getStrategyList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Strategy> strategyList = null;
        if (request.getParameter("Status") != null){
            strategyList = new StrategyManageImpl().getStrategyList(Integer.parseInt(request.getParameter("Status")));

        }

        response.setCharacterEncoding("UTF-8");
        response.setContentType("TEXT/JSON");

        response.getWriter().write(new Gson().toJson(strategyList == null?new JsonObject():strategyList));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
