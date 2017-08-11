package com.skyteam.letu.servlet.User;

import com.google.gson.Gson;
import com.skyteam.letu.entities.User;
import com.skyteam.letu.server.impl.UserManageImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 更新用户全部信息
 * Created by rick- on 2017/5/9.
 */
@WebServlet(name = "updateUser", value = "/updateUser")
public class updateUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String UserJsonString = request.getParameter("UserJsonString");
        User user = new Gson().fromJson(UserJsonString, User.class);
        boolean isOK = false;

        if (null != user){
            isOK = new UserManageImpl().updateUser(user);
        }

        response.setContentType("TEXT/JSON");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(Boolean.toString(isOK));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
