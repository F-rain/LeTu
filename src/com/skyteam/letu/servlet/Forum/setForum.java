package com.skyteam.letu.servlet.Forum;

import com.google.gson.Gson;
import com.skyteam.letu.entities.Forum;
import com.skyteam.letu.server.impl.ForumManageImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 发送一条论坛动态
 * Created by rick- on 2017/6/22.
 */
@WebServlet(name = "setForum", value = "/setForum")
public class setForum extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Forum forum = null;
        boolean is_success = false;

        if (request.getParameter("Forum") != null){
            forum = new Gson().fromJson(request.getParameter("Forum"), Forum.class);

            is_success = new ForumManageImpl().setForum(forum);
        }

        response.setCharacterEncoding("UTF-8");
        response.setContentType("TEXT/JSON");

        response.getWriter().write(Boolean.toString(is_success));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
