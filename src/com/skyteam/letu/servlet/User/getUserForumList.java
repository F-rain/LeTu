package com.skyteam.letu.servlet.User;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.skyteam.letu.entities.Forum;
import com.skyteam.letu.server.impl.UserManageImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "getUserForumList", value = "/getMyForumList")
public class getUserForumList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Forum> forumList = null;

        if (request.getParameter("UserID") != null){
            forumList = new UserManageImpl().getForumList(request.getParameter("UserID"));
        }

        response.setCharacterEncoding("UTF-8");
        response.setContentType("TEXT/JSON");
        response.getWriter().write(new Gson().toJson(forumList == null?new JsonObject():forumList));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
