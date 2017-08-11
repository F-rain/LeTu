package com.skyteam.letu.servlet.TravelNote;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.skyteam.letu.entities.TravleNote;
import com.skyteam.letu.server.impl.TravleNoteManageImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 获取游记列表
 * Created by rick- on 2017/6/22.
 */
@WebServlet(name = "getTravleNoteList", value = "/getTravleNoteList")
public class getTravleNoteList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<TravleNote> travleNoteList = null;

        if (request.getParameter("Status") != null){
            travleNoteList = new TravleNoteManageImpl().getTravleNoteList(Integer.parseInt(request.getParameter("Status")));

        }

        response.setContentType("TEXT/JSON");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(travleNoteList == null?new JsonObject():travleNoteList));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
