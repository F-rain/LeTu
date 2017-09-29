package com.skyteam.letu.servlet.Strategy;

import com.google.gson.Gson;
import com.skyteam.letu.entities.Strategy;
import com.skyteam.letu.server.impl.StrategyManageImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 添加一条攻略
 * Created by rick- on 2017/6/22.
 */
@WebServlet(name = "setStrategy", value = "/setStrategy")
public class setStrategy extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Strategy strategy = null;
        String ID = null;
        if (request.getParameter("Strategy") != null && request.getParameter("Status") != null){
            strategy = new Gson().fromJson(request.getParameter("Strategy"), Strategy.class);

            ID = new StrategyManageImpl().setStrategy(strategy, Integer.parseInt(request.getParameter("Status")));
        }

        response.setCharacterEncoding("UTF-8");
        response.setContentType("TEXT/JSON");

        response.getWriter().write(ID);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
