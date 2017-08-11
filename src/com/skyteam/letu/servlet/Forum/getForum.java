package com.skyteam.letu.servlet.Forum;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.skyteam.letu.entities.Forum;
import com.skyteam.letu.server.impl.ForumManageImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 获取单条动态信息
 * Created by rick- on 2017/6/22.
 */
@WebServlet(name = "getForum", value = "/getForum")
public class getForum extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Forum forum = null;
        if (request.getParameter("ForumID") != null){
            forum = new ForumManageImpl().getForum(request.getParameter("ForumID"));
        }

        response.setCharacterEncoding("UTF-8");
        response.setContentType("TEXT/JSON");

        response.getWriter().write(new Gson().toJson(forum == null?new JsonObject():forum));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
