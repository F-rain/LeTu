package com.skyteam.letu.servlet.Strategy;

import com.skyteam.letu.server.impl.StrategyManageImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除一条攻略
 * Created by rick- on 2017/6/22.
 */
@WebServlet(name = "delStrategy", value = "/delStrategy")
public class delStrategy extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean is_success = false;

        if (request.getParameter("UserID") != null && request.getParameter("StrategyID") != null){
            is_success = new StrategyManageImpl().delStrategy(request.getParameter("UserID"), request.getParameter("StrategyID"));
        }

        response.setContentType("TEXT/JSON");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(Boolean.toString(is_success));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
