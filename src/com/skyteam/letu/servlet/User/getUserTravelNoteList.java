package com.skyteam.letu.servlet.User;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.skyteam.letu.entities.TravleNote;
import com.skyteam.letu.server.impl.UserManageImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "getUserTravelNoteList", value = "/getMyTravelNoteList")
public class getUserTravelNoteList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<TravleNote> travleNoteList = null;

        if (request.getParameter("UserID") != null){
            travleNoteList = new UserManageImpl().getTravleNoteList(request.getParameter("UserID"));

        }

        response.setContentType("TEXT/JSON");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(travleNoteList == null?new JsonObject():travleNoteList));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
