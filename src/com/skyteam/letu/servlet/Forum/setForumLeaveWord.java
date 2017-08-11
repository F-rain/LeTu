package com.skyteam.letu.servlet.Forum;

import com.google.gson.Gson;
import com.skyteam.letu.entities.Forum;
import com.skyteam.letu.entities.LeaveWord;
import com.skyteam.letu.server.impl.ForumManageImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 向论坛动态添加一条评论
 * Created by rick- on 2017/6/22.
 */
@WebServlet(name = "setForumLeaveWord", value = "/setForumLeaveWord")
public class setForumLeaveWord extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LeaveWord leaveWord = null;
        boolean is_success = false;

        if (request.getParameter("ForumID") != null && request.getParameter("leaveword") != null){
            leaveWord = new Gson().fromJson(request.getParameter("leaveword"), LeaveWord.class);

            is_success = new ForumManageImpl().setForumLeaveWord(request.getParameter("ForumID"), leaveWord);
        }

        response.setContentType("TEXT/JSON");
        response.setCharacterEncoding("UTF-8");

        response.getWriter().write(Boolean.toString(is_success));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
