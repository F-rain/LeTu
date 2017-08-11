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
 * 更新修改一条攻略
 * Created by rick- on 2017/6/22.
 */
@WebServlet(name = "updateStrategy", value = "/updateStrategy")
public class updateStrategy extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Strategy strategy = null;
        boolean is_success = false;
        if (request.getParameter("StrategyID") != null && request.getParameter("Strategy") != null){
            strategy = new Gson().fromJson(request.getParameter("Stratgy"), Strategy.class);

            is_success = new StrategyManageImpl().updateStrategy(request.getParameter("SrategyID"), strategy);
        }

        response.setCharacterEncoding("UTF-8");
        response.setContentType("TEXT/JSON");

        response.getWriter().write(Boolean.toString(is_success));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
