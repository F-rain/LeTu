package com.skyteam.letu.servlet.Strategy;

import com.google.gson.Gson;
import com.skyteam.letu.entities.LeaveWord;
import com.skyteam.letu.server.impl.StrategyManageImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 对攻略添加一条评论
 * Created by rick- on 2017/6/22.
 */
@WebServlet(name = "setStrategyLeaveWoed", value = "/setStrategyLeaveWord")
public class setStrategyLeaveWoed extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LeaveWord leaveWord = null;
        boolean is_success = false;
        if (request.getParameter("StrategyID") != null && request.getParameter("leaveword") != null){
            leaveWord = new Gson().fromJson(request.getParameter("leaveword"), LeaveWord.class);

            is_success = new StrategyManageImpl().setStrategyLeaveWord(request.getParameter("StrategyID"), leaveWord);
        }
        response.setContentType("TEXT/JSON");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(Boolean.toString(is_success));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
