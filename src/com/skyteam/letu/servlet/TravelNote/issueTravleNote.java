package com.skyteam.letu.servlet.TravelNote;

import com.skyteam.letu.server.impl.TravleNoteManageImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 发布一条游记
 * Created by rick- on 2017/6/22.
 */
@WebServlet(name = "issueTravleNote", value = "/issueTravleNote")
public class issueTravleNote extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean is_success = false;

        if (request.getParameter("NoteID") != null){
            is_success = new TravleNoteManageImpl().issueTravleNote(request.getParameter("NoteID"));
        }

        response.setCharacterEncoding("UTF-8");
        response.setContentType("TEXT/JSON");
        response.getWriter().write(Boolean.toString(is_success));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
