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

/**
 * 获取一条游记
 * Created by rick- on 2017/6/22.
 */
@WebServlet(name = "getTravleNote", value = "/getTravleNote")
public class getTravleNote extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TravleNote travleNote = null;

        if (request.getParameter("NoteID") != null && request.getParameter("Status") != null){
            travleNote = new TravleNoteManageImpl().getTravleNote(request.getParameter("NoteID"), Integer.parseInt(request.getParameter("Status")));

        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("TEXT/JSON");
        response.getWriter().write(new Gson().toJson(travleNote == null?new JsonObject():travleNote));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
