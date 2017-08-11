package com.skyteam.letu.servlet.Forum;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.skyteam.letu.entities.LeaveWord;
import com.skyteam.letu.server.impl.ForumManageImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 获取某条论坛动态的评论列表
 * Created by rick- on 2017/6/22.
 */
@WebServlet(name = "getForumLeaveWord", value = "/getForumLeaveWord")
public class getForumLeaveWord extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<LeaveWord> leaveWordList = null;

        if (request.getParameter("ForumID") != null){
            leaveWordList = new ForumManageImpl().getForumLeaveWords(request.getParameter("ForumID"));
        }

        response.setCharacterEncoding("UTF-8");
        response.setContentType("TEXT/JSON");

        response.getWriter().write(new Gson().toJson(leaveWordList == null?new JsonObject():leaveWordList));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
