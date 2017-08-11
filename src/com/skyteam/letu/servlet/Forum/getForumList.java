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
import java.util.List;

/**
 * 获取论坛动态列表
 * Created by rick- on 2017/6/22.
 */
@WebServlet(name = "getForumList", value = "/getForumList")
public class getForumList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Forum> forumList = null;

        forumList = new ForumManageImpl().getForumList();

        response.setCharacterEncoding("UTF-8");
        response.setContentType("TEXT/JSON");
        response.getWriter().write(new Gson().toJson(forumList == null?new JsonObject():forumList));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
