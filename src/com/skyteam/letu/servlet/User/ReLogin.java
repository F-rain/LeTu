package com.skyteam.letu.servlet.User;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.skyteam.letu.entities.User;
import com.skyteam.letu.server.impl.UserManageImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重新登录
 * Created by rick- on 2017/5/6.
 */
@WebServlet(name = "ReLogin", value = "/relogin")
public class ReLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = null;
        String UserTel = request.getParameter("UserTel");
        String meid = request.getParameter("meid");
        if (null != UserTel && null != meid){
            user = new UserManageImpl().getUser(UserTel, meid);
        }

        response.setContentType("TEXT/JSON");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(null==user?new JsonObject():user));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
