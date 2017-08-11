package com.skyteam.letu.dao.impl;

import com.skyteam.letu.dao.ForumDao;
import com.skyteam.letu.entities.Forum;
import com.skyteam.letu.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by rick- on 2017/5/3.
 */
public class ForumDaoImpl implements ForumDao {
    /**
     * 获取论坛动态列表
     *
     * @return
     */
    @Override
    public List<Forum> getForumList() {
        List<Forum> forumList = null;

        Connection conn = DBUtil.getConn();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT ForumID FROM forum");
            forumList = new ArrayList<>();
            while (resultSet.next()){
                Forum forum = getForum(resultSet.getString("ForumID"));
                forumList.add(forum);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.closeConn(conn, statement);
        }

        return forumList;
    }

    /**
     * 获取单个动态信息
     *
     * @param ForumID
     * @return
     */
    @Override
    public Forum getForum(String ForumID) {
        Forum forum = null;

        Connection conn = DBUtil.getConn();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM forum WHERE ForumID = '"+ ForumID +"'");

            resultSet.next();
            forum = new Forum();
            forum.setUserID(resultSet.getString("UserID"));
            forum.setForumID(resultSet.getString("ForumID"));
            forum.setTextContent(resultSet.getString("TextContent"));
            forum.setForumTime(resultSet.getString("ForumTime"));
            forum.setCityName(resultSet.getString("CityName"));
            forum.setFeatureName(resultSet.getString("FeatureName"));
            forum.setLikeNum(resultSet.getString("LikeNum"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.closeConn(conn, statement);
        }

        return forum;
    }

    /**
     * 添加一条动态
     *
     * @param forum
     * @return
     */
    @Override
    public boolean setForum(Forum forum) {
        boolean is_success = false;
        Connection conn = DBUtil.getConn();
        Statement statement = null;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式


        try {
            statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO forum VALUES ('"+ forum.getUserID() +"', '"+ forum.getForumID() +"', '"+ forum.getTextContent() +"', '"+ df.format(new Date()) +"', '"+ forum.getCityName() +"', '"+ forum.getFeatureName() +"', '0')");
            is_success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn, statement);
        }

        return is_success;
    }

    /**
     * 删除一条动态
     *
     * @param ForumID
     * @return
     */
    @Override
    public boolean delForum(String ForumID) {
        boolean is_success = false;
        Connection conn = DBUtil.getConn();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            statement.executeUpdate("DELETE FROM forum WHERE ForumID = '"+ ForumID +"'");
            is_success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn, statement);
        }

        return is_success;
    }
}
