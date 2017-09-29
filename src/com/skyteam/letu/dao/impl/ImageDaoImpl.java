package com.skyteam.letu.dao.impl;

import com.skyteam.letu.dao.ImageDao;
import com.skyteam.letu.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ImageDaoImpl implements ImageDao {
    @Override
    public boolean saveImagePath(String Type, String ID, String ImagePath) {
        boolean is_success = false;
        Connection conn = DBUtil.getConn();
        Statement statement = null;
        String ImageID = UUID.randomUUID().toString();
        try {
            statement = conn.createStatement();
            switch (Type){
                case "Note":
                    statement.executeUpdate("INSERT INTO NoteImage VALUES('"+ ImageID +"', '"+ ID +"', '"+ ImagePath +"') ");
                    break;
                case "Forum":
                    statement.executeUpdate("INSERT INTO ForumImage VALUES('"+ ImageID +"', '"+ ID +"', '"+ ImagePath +"') ");
                    break;
                case "Avatar":
                    statement.executeUpdate("INSERT INTO avatar VALUES('"+ ImageID +"', '"+ ID +"', '"+ ImagePath +"') ");
                    break;
            }
            is_success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn, statement);
        }
        return is_success;
    }

    @Override
    public List<String> getImagePath(String Type, String ID) {
        List<String> imagePathList = null;
        Connection conn = DBUtil.getConn();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            ResultSet resultSet = null;
            switch (Type){
                case "Note":
                    resultSet = statement.executeQuery("SELECT ImageUrl FROM NoteImage WHERE NoteID = '"+ ID +"'");
                    break;
                case "Forum":
                    resultSet = statement.executeQuery("SELECT ImageUrl FROM ForumImage WHERE ForumID = '"+ ID +"'");
                    break;
                case "Avatar":
                    resultSet = statement.executeQuery("SELECT ImageUrl FROM avatar WHERE UserID = '"+ ID +"'");
                    break;
            }
            imagePathList = new ArrayList<>();
            while (resultSet.next()){
                imagePathList.add(resultSet.getString("ImageUrl"));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn, statement);
        }

        return imagePathList;
    }
}
