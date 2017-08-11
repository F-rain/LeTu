package com.skyteam.letu.dao.impl;

import com.skyteam.letu.dao.LeaveWordDao;
import com.skyteam.letu.entities.LeaveWord;
import com.skyteam.letu.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rick- on 2017/5/3.
 */
public class LeaveWordDaoImpl implements LeaveWordDao {
    /**
     * 获取论坛动态的留言评论
     *
     * @param ForumID
     * @return
     */
    @Override
    public List<LeaveWord> getForumLeaveWords(String ForumID) {
        List<LeaveWord> leaveWordList = null;

        Connection conn = DBUtil.getConn();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM forumleaveword WHERE ForumID = '"+ ForumID +"'");
            leaveWordList = new ArrayList<>();

            while (resultSet.next()){
                LeaveWord leaveWord = new LeaveWord();
                leaveWord.setID(resultSet.getString("ForumID"));
                leaveWord.setFromUserID(resultSet.getString("FromUserID"));
                leaveWord.setToUserID(resultSet.getString("ToUserID"));
                leaveWord.setContent(resultSet.getString("Content"));

                leaveWordList.add(leaveWord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn, statement);
        }


        return leaveWordList;
    }

    /**
     * 获取攻略的留言评论
     *
     * @param StrategyID
     * @return
     */
    @Override
    public List<LeaveWord> getStrategyLeaveWords(String StrategyID) {
        List<LeaveWord> leaveWordList = null;

        Connection conn = DBUtil.getConn();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM strategyleaveword WHERE ForumID = '"+ StrategyID +"'");
            leaveWordList = new ArrayList<>();

            while (resultSet.next()){
                LeaveWord leaveWord = new LeaveWord();
                leaveWord.setID(resultSet.getString("StrategyID"));
                leaveWord.setFromUserID(resultSet.getString("FromUserID"));
                leaveWord.setToUserID(resultSet.getString("ToUserID"));
                leaveWord.setContent(resultSet.getString("Content"));

                leaveWordList.add(leaveWord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn, statement);
        }


        return leaveWordList;
    }

    /**
     * 获取游记的留言评论
     *
     * @param NoteID
     * @return
     */
    @Override
    public List<LeaveWord> getNoteLeaveWords(String NoteID) {
        List<LeaveWord> leaveWordList = null;

        Connection conn = DBUtil.getConn();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM noteleaveword WHERE ForumID = '"+ NoteID +"'");
            leaveWordList = new ArrayList<>();

            while (resultSet.next()){
                LeaveWord leaveWord = new LeaveWord();
                leaveWord.setID(resultSet.getString("NoteID"));
                leaveWord.setFromUserID(resultSet.getString("FromUserID"));
                leaveWord.setToUserID(resultSet.getString("ToUserID"));
                leaveWord.setContent(resultSet.getString("Content"));

                leaveWordList.add(leaveWord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn, statement);
        }


        return leaveWordList;
    }

    /**
     * 向一条论坛动态添加一条评论信息
     *
     * @param ForumID
     * @param leaveWord
     * @return
     */
    @Override
    public boolean setForumLeaveWord(String ForumID, LeaveWord leaveWord) {
        boolean is_success = false;
        Connection conn = DBUtil.getConn();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO forumleaveword VALUES ('"+ ForumID +"', '"+ leaveWord.getFromUserID() +"', '"+ leaveWord.getToUserID() +"', '"+ leaveWord.getContent() +"')");
            is_success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn, statement);
        }

        return is_success;
    }

    /**
     * 向一条攻略添加一条评论信息
     *
     * @param StrategyID
     * @param leaveWord
     * @return
     */
    @Override
    public boolean setStrategyLeaveWord(String StrategyID, LeaveWord leaveWord) {
        boolean is_success = false;
        Connection conn = DBUtil.getConn();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO strategyleaveword VALUES ('"+ StrategyID +"', '"+ leaveWord.getFromUserID() +"', '"+ leaveWord.getToUserID() +"', '"+ leaveWord.getContent() +"')");
            is_success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn, statement);
        }

        return is_success;
    }

    /**
     * 向一条游记添加一条评论信息
     *
     * @param NoteID
     * @param leaveWord
     * @return
     */
    @Override
    public boolean setNoteLeaveWord(String NoteID, LeaveWord leaveWord) {
        boolean is_success = false;
        Connection conn = DBUtil.getConn();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO noteleaveword VALUES ('"+ NoteID +"', '"+ leaveWord.getFromUserID() +"', '"+ leaveWord.getToUserID() +"', '"+ leaveWord.getContent() +"')");
            is_success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn, statement);
        }

        return is_success;
    }
}
