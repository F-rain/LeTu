package com.skyteam.letu.servlet.User;

import com.skyteam.letu.server.impl.UserManageImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 更新用户名字（昵称）
 * Created by rick- on 2017/5/10.
 */
@WebServlet(name = "updateUserName", value = "/updateUserName")
public class updateUserName extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String UserID = request.getParameter("UserID");
        String UserName = request.getParameter("UserName");
        boolean isOK = false;

        if (null != UserID && null != UserName){
            isOK = new UserManageImpl().updateUserName(UserID, UserName);
        }

        response.setContentType("TEXT/JSON");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(Boolean.toString(isOK));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
