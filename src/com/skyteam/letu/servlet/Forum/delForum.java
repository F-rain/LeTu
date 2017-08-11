package com.skyteam.letu.servlet.Forum;

import com.skyteam.letu.server.impl.ForumManageImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除一条动态
 * Created by rick- on 2017/6/22.
 */
@WebServlet(name = "delForum", value = "/delForum")
public class delForum extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean is_success = false;
        if (request.getParameter("ForumID") != null && request.getParameter("UserID") != null){
            is_success = new ForumManageImpl().delForum(request.getParameter("UserID"), request.getParameter("ForumID"));
        }

        response.setContentType("TEXT/JSON");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(Boolean.toString(is_success));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
