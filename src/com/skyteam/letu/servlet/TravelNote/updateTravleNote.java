package com.skyteam.letu.servlet.TravelNote;

import com.google.gson.Gson;
import com.skyteam.letu.entities.TravleNote;
import com.skyteam.letu.server.impl.TravleNoteManageImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 更新修改一条游记
 * Created by rick- on 2017/6/22.
 */
@WebServlet(name = "updateTravleNote", value = "/updateTravleNote")
public class updateTravleNote extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TravleNote travleNote = null;
        boolean is_success = false;

        if (request.getParameter("NoteID") != null && request.getParameter("TravleNote") != null){
            travleNote = new Gson().fromJson(request.getParameter("TravleNote"), TravleNote.class);

            is_success = new TravleNoteManageImpl().updateTravleNote(request.getParameter("NoteID"), travleNote);
        }

        response.setContentType("TEXT/JSON");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(Boolean.toString(is_success));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
