package com.skyteam.letu.dao.impl;

import com.skyteam.letu.dao.Stra_NoteDao;
import com.skyteam.letu.entities.Strategy;
import com.skyteam.letu.entities.TravleNote;
import com.skyteam.letu.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by rick- on 2017/5/3.
 */
public class Stra_NoteDaoImpl implements Stra_NoteDao {
    /**
     * 获取攻略内容列表
     * @param Status （状态码 0代表编辑中 1代表已完成 2代表已发布）
     * @return 返回List<Strategy>
     */
    @Override
    public List<Strategy> getStrategyList(int Status) {
        List<Strategy> strategyList = null;

        Connection conn = DBUtil.getConn();
        Statement statement = null;

        try {
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT StrategyID FROM strategy WHERE Status = '"+ Status +"'");

            while (resultSet.next()){
                String StrategyID = resultSet.getString("StrategyID");
                Strategy strategy = new Strategy();

                strategy = new Stra_NoteDaoImpl().getStrategy(StrategyID, Status);

                strategyList = new ArrayList<>();
                strategyList.add(strategy);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.closeConn(conn, statement);
        }

        return strategyList;
    }

    /**
     * 获取游记内容列表
     * @param Status （状态码 0代表编辑中 1代表已完成 2代表已发布）
     * @return 返回List<TravleNote>
     */
    @Override
    public List<TravleNote> getTravleNoteList(int Status) {
        List<TravleNote> travleNoteList = null;

        Connection conn = DBUtil.getConn();
        Statement statement = null;
        try {
            statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT NoteID FROM travelnote WHERE Status = '"+ Status +"'");
            while (resultSet.next()){
                String NoteID = resultSet.getString("NoteID");
                TravleNote travleNote = new TravleNote();

                travleNote = new Stra_NoteDaoImpl().getTravleNote(NoteID, Status);

                travleNoteList = new ArrayList<>();
                travleNoteList.add(travleNote);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.closeConn(conn, statement);
        }

        return travleNoteList;
    }

    /**
     * 获取单个攻略内容
     *
     * @param StrategyID （攻略ID）
     * @param Status （状态码 0代表编辑中 1代表已完成 2代表已发布）
     * @return 返回Strategy对象
     */
    @Override
    public Strategy getStrategy(String StrategyID, int Status) {
        Strategy strategy = null;

        Connection conn = DBUtil.getConn();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM strategy WHERE StrategyID = '"+ StrategyID +"' AND Status = '"+ Status +"'");

            resultSet.next();
            strategy = new Strategy();
            strategy.setUserID(resultSet.getString("UserID"));
            strategy.setStrategyId(StrategyID);
            strategy.setTextContent(resultSet.getString("TextContent"));
            strategy.setStrategyTime(resultSet.getString("StrategyTime"));
            strategy.setCityName(resultSet.getString("CityName"));
            strategy.setFeatureName(resultSet.getString("FeatureName"));
            strategy.setLikeNum(resultSet.getString("LikeNum"));
            strategy.setStatus(Status);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.closeConn(conn, statement);
        }

        return strategy;
    }

    /**
     * 获取单个游记内容
     *
     * @param NoteID （游记ID）
     * @param Status （状态码 0代表编辑中 1代表已完成 2代表已发布）
     * @return 返回TravleNote对象
     */
    @Override
    public TravleNote getTravleNote(String NoteID, int Status) {
        TravleNote travleNote = null;

        Connection conn = DBUtil.getConn();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM travelnote WHERE NoteID = '"+ NoteID +"' AND Status = '"+ Status +"'");

            resultSet.next();
            travleNote = new TravleNote();
            travleNote.setUserID(resultSet.getString("UserID"));
            travleNote.setNodeID(NoteID);
            travleNote.setTextContent(resultSet.getString("TextContent"));
            travleNote.setNoteTime(resultSet.getString("NoteTime"));
            travleNote.setCityName(resultSet.getString("CityName"));
            travleNote.setFeatureName(resultSet.getString("FeatureName"));
            travleNote.setLikeNum(resultSet.getString("LikeNum"));
            travleNote.setStatus(Status);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.closeConn(conn, statement);
        }

        return travleNote;
    }

    /**
     * 添加攻略内容
     *
     * @param strategy （攻略对象）
     * @param Status （状态码 0代表编辑中 1代表已完成 2代表已发布）
     * @return 返回一个布尔值
     */
    @Override
    public boolean setStrategy(Strategy strategy, int Status) {
        boolean is_success = false;
        String StrategyID = UUID.randomUUID().toString();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

        Connection conn = DBUtil.getConn();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO strategy VALUES ('"+ strategy.getUserID() +"', '"+ StrategyID +"', '"+ strategy.getTextContent() +"', '"+ df.format(new Date()) +"', '"+ strategy.getCityName() +"', '"+ strategy.getFeatureName() +"', '"+ Status +"', '0')");
            is_success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.closeConn(conn, statement);
        }

        return is_success;
    }

    /**
     * 添加游记内容
     *
     * @param travleNote （游记对象）
     * @param Status （状态码 0代表编辑中 1代表已完成 2代表已发布）
     * @return 返回一个布尔值
     */
    @Override
    public boolean setTravleNote(TravleNote travleNote, int Status) {
        boolean is_success = false;
        String NoteID = UUID.randomUUID().toString();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

        Connection conn = DBUtil.getConn();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO travelnote VALUES ('"+ travleNote.getUserID() +"', '"+ NoteID +"', '"+ travleNote.getTextContent() +"', '"+ df.format(new Date()) +"', '"+ travleNote.getCityName() +"', '"+ travleNote.getFeatureName() +"', '"+ Status +"', '0')");
            is_success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.closeConn(conn, statement);
        }

        return is_success;
    }

    /**
     * 发布一个攻略
     *
     * @param StrategyID （攻略ID）
     * @return 返回一个布尔值
     */
    @Override
    public boolean issueStrategy(String StrategyID) {
        boolean is_success = false;

        Connection conn = DBUtil.getConn();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            statement.executeUpdate("UPDATE strategy SET Status = '2' WHERE StrategyID = '"+ StrategyID+"'");
            is_success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.closeConn(conn, statement);
        }

        return is_success;
    }

    /**
     * 发布一个游记
     *
     * @param NoteID （游记ID）
     * @return 返回一个布尔值
     */
    @Override
    public boolean issueTravleNote(String NoteID) {
        boolean is_success = false;

        Connection conn = DBUtil.getConn();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            statement.executeUpdate("UPDATE travelnote SET Status = '2' WHERE StrategyID = '"+ NoteID+"'");
            is_success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.closeConn(conn, statement);
        }

        return is_success;
    }

    /**
     * 更新一个攻略
     *
     * @param StrategyID
     * @param strategy
     * @return
     */
    @Override
    public boolean updateStrategy(String StrategyID, Strategy strategy) {
        boolean is_success = false;

        Connection conn = DBUtil.getConn();
        Statement statement = null;
        if (strategy.getStatus() != 2) {
            try {
                statement = conn.createStatement();
                statement.executeUpdate("UPDATE strategy SET TextContent = '" + strategy.getTextContent() + "' WHERE StrategyID = '"+ strategy.getStrategyId()+"'");
                statement.executeUpdate("UPDATE strategy SET CityName = '" + strategy.getCityName() + "' WHERE StrategyID = '"+ strategy.getStrategyId()+"'");
                statement.executeUpdate("UPDATE strategy SET FeatureName = '" + strategy.getFeatureName() + "' WHERE StrategyID = '"+ strategy.getStrategyId()+"'");
                statement.executeUpdate("UPDATE strategy SET LikeNum = '" + strategy.getLikeNum() + "' WHERE StrategyID = '"+ strategy.getStrategyId()+"'");

                is_success = true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                DBUtil.closeConn(conn, statement);
            }

        }
        return is_success;
    }

    /**
     * 更新一个游记
     *
     * @param NoteID
     * @param travleNote
     * @return
     */
    @Override
    public boolean updateTravleNote(String NoteID, TravleNote travleNote) {
        boolean is_success = false;

        Connection conn = DBUtil.getConn();
        Statement statement = null;
        if (travleNote.getStatus() != 2) {
            try {
                statement = conn.createStatement();
                statement.executeUpdate("UPDATE travelnote SET TextContent = '" + travleNote.getTextContent() + "' WHERE StrategyID = '"+ travleNote.getNodeID()+"'");
                statement.executeUpdate("UPDATE travelnote SET CityName = '" + travleNote.getCityName() + "' WHERE StrategyID = '"+ travleNote.getNodeID()+"'");
                statement.executeUpdate("UPDATE travelnote SET FeatureName = '" + travleNote.getFeatureName() + "' WHERE StrategyID = '"+ travleNote.getNodeID()+"'");
                statement.executeUpdate("UPDATE travelnote SET LikeNum = '" + travleNote.getLikeNum() + "' WHERE StrategyID = '"+ travleNote.getNodeID()+"'");

                is_success = true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                DBUtil.closeConn(conn, statement);
            }

        }
        return is_success;
    }

    /**
     * 删除一个攻略
     *
     * @param StrategyID （攻略ID）
     * @return 返回一个布尔值
     */
    @Override
    public boolean delStrategy(String StrategyID) {
        boolean is_success = false;

        Connection conn = DBUtil.getConn();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            statement.executeUpdate("DELETE FROM strategy WHERE StrategyID = '"+ StrategyID +"'");
            is_success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn, statement);
        }

        return is_success;
    }

    /**
     * 删除一个游记
     *
     * @param NoteID （游记ID）
     * @return 返回一个布尔值
     */
    @Override
    public boolean delTravleNote(String NoteID) {
        boolean is_success = false;

        Connection conn = DBUtil.getConn();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            statement.executeUpdate("DELETE FROM travelnote WHERE NoteID = '"+ NoteID +"'");
            is_success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn, statement);
        }

        return is_success;
    }
}
