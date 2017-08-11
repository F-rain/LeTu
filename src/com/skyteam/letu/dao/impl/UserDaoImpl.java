package com.skyteam.letu.dao.impl;

import com.skyteam.letu.dao.Stra_NoteDao;
import com.skyteam.letu.dao.UserDao;
import com.skyteam.letu.entities.Strategy;
import com.skyteam.letu.entities.TravleNote;
import com.skyteam.letu.entities.User;
import com.skyteam.letu.util.DBUtil;

import java.lang.annotation.Target;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by rick- on 2017/5/3.
 */
public class UserDaoImpl implements UserDao {

    /**
     * 通过sql语句获取用户对象
     * @param sql
     * @return
     */
    private User getUserUseSql(String sql){
        User user =null;
        Connection conn = DBUtil.getConn();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                user = new User();
                user.setUserID(resultSet.getString("UserID"));
                user.setUserTel(resultSet.getString("UserTel"));
                user.setUserSex(resultSet.getBoolean("UserSex"));
                user.setUserName(resultSet.getString("UserName"));
                user.setUserBirth(resultSet.getString("UserBirth"));
                user.setMeid(resultSet.getString("Meid"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.closeConn(conn, statement);
        }

        return user;
    }




    /**
     * 通过手机号获取用户信息
     *
     * @param UserTel （用户手机号）
     * @return User（一个用户的对象）
     */
    @Override
    public User getUser(String UserTel) {
        String sql = "SELECT * FROM user WHERE UserTel = '"+ UserTel +"'";

        return getUserUseSql(sql);
    }

    /**
     * 通过用户的手机号和手机唯一识别码获取用户信息
     *
     * @param UserTel （用户手机号）
     * @param meid    （用户手机唯一识别码）
     * @return User（一个用户的对象）
     */
    @Override
    public User getUser(String UserTel, String meid) {
        String sql = "SELECT * FROM user WHERE UserTel = '"+ UserTel +"' AND Meid = '"+ meid+"'";

        return getUserUseSql(sql);
    }

    /**
     * 通过用户手机号，手机唯一识别码和密码获取用户信息
     *
     * @param UserTel  （用户手机号）
     * @param Password （用户密码）
     * @param meid     （用户手机唯一识别码）
     * @return User（一个用户的对象）
     */
    @Override
    public User getUser(String UserTel, String Password, String meid) {
        String sql = "SELECT * FROM user WHERE UserTel = '"+UserTel+"' AND Password = '"+Password+"'";
        /**
         * 如果meid不为空，则应判断用户是否更换了常用手机，是否需要更新meid
         */
        return getUserUseSql(sql);
    }

    /**
     * 通过用户手机号和用户手机唯一识别码创建用户
     *
     * @param UserTel
     * @param meid
     * @return
     */
    @Override
    public User setUser(String UserTel,String Password, String meid) {
        boolean success = false;

        if (getUser(UserTel) != null){
            return null;
        }

        //生成用户唯一标识ID
        String UserID = UUID.randomUUID().toString();
        Connection conn = DBUtil.getConn();
        Statement statement = null;

        try {
            statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO user(UserID, Password, UserTel, Meid) VALUES ('"+ UserID +"', '"+ Password +"',  '"+ UserTel +"', '"+ meid +"')");
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.closeConn(conn, statement);
        }

        if (success){
            return getUser(UserTel);
        }
        return null;
    }

    /**
     * 获取用户关注的人的列表
     *
     * @param UserID （用户ID）
     * @return List<User>（一组用户对象）
     */
    @Override
    public List<User> getConcernedUser(String UserID) {
        List<User> userList = null;

        Connection conn = DBUtil.getConn();
        Statement statement= null;
        try {
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT TargetUserID FROM userrelationship WHERE UserID = '"+ UserID +"'");

            while (resultSet.next()){
                String TargetUserID = resultSet.getString("TargetUserID");
                userList = new ArrayList<>();
                userList.add(getUserUseSql("SELECT * FROM user WHERE UserID = '"+ TargetUserID +"'"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.closeConn(conn, statement);
        }

        return userList;
    }

    /**
     * 获取用户收藏的攻略
     *
     * @param UserID （用户ID）
     * @return List<Strategy>（一组攻略对象）
     */
    @Override
    public List<Strategy> getUserCollectStrategy(String UserID) {
        List<Strategy> strategyList = null;
        Stra_NoteDao stra_noteDao = new Stra_NoteDaoImpl();

        Connection conn = DBUtil.getConn();
        Statement statement = null;

        try {
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT StrategyID FROM usercollectstrategy WHERE UserID = '"+ UserID +"'");

            while (resultSet.next()){
                String StrategyID = resultSet.getString("StrategyID");
                strategyList = new ArrayList<>();
                strategyList.add(stra_noteDao.getStrategy(StrategyID, 2));
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
     * 获取用户收藏的游记
     *
     * @param UserID （用户ID）
     * @return List<TravleNote> （一组游记对象）
     */
    @Override
    public List<TravleNote> getUserCollectNote(String UserID) {
        List<TravleNote> noteList = null;
        Stra_NoteDao stra_noteDao = new Stra_NoteDaoImpl();

        Connection conn = DBUtil.getConn();
        Statement statement = null;

        try {
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT NoteID FROM usercollectnote WHERE UserID = '" + UserID + "'");

            while (resultSet.next()){
                String NoteID = resultSet.getString("NoteID");
                noteList = new ArrayList<>();
                noteList.add(stra_noteDao.getTravleNote(NoteID, 2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.closeConn(conn, statement);
        }

        return noteList;
    }

    /**
     * 更新用户全部信息
     *
     * @param user
     * @return
     */
    @Override
    public boolean updateUser(User user) {
        Connection conn = DBUtil.getConn();
        Statement statement = null;

        try {
            statement = conn.createStatement();
            statement.executeUpdate("UPDATE user SET UserName = '"+ user.getUserName() +"' WHERE UserID = '"+ user.getUserID() +"'");
            statement.executeUpdate("UPDATE user SET UserTel = '"+ user.getUserTel() +"' WHERE UserID = '"+ user.getUserID() +"'");
            statement.executeUpdate("UPDATE user SET UserSex = '"+ user.isUserSex() +"' WHERE UserID = '"+ user.getUserID() +"'");
            statement.executeUpdate("UPDATE user SET UserBirth = '"+ user.getUserBirth() +"' WHERE UserID = '"+ user.getUserID() +"'");

            statement.close();
            conn.close();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.closeConn(conn, statement);
        }

        return false;
    }

    /**
     * 更新用户昵称
     *
     * @param UserID
     * @param UserName
     * @return
     */
    @Override
    public boolean updateUserName(String UserID, String UserName) {
        Connection conn = DBUtil.getConn();
        Statement statement = null;

        try {
            statement = conn.createStatement();
            statement.executeUpdate("UPDATE user SET UserName = '"+ UserName +"' WHERE UserID = '"+ UserID +"'");

            statement.close();
            conn.close();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.closeConn(conn, statement);
        }

        return false;
    }

    /**
     * 更新用户手机号
     *
     * @param UserID
     * @param UserTel
     * @return
     */
    @Override
    public boolean updateUserTel(String UserID, String UserTel) {
        Connection conn = DBUtil.getConn();
        Statement statement = null;

        try {
            statement = conn.createStatement();
            statement.executeUpdate("UPDATE user SET UserTel = '"+ UserTel +"' WHERE UserID = '"+ UserID +"'");

            statement.close();
            conn.close();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.closeConn(conn, statement);
        }

        return false;
    }

    /**
     * 更新用户密码
     *
     * @param UserID
     * @param Password
     * @return
     */
    @Override
    public boolean updateUserPassword(String UserID, String Password) {
        Connection conn = DBUtil.getConn();
        Statement statement = null;

        try {
            statement = conn.createStatement();
            statement.executeUpdate("UPDATE user SET Password = '"+ Password +"' WHERE UserID = '"+ UserID +"'");

            statement.close();
            conn.close();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.closeConn(conn, statement);
        }

        return false;
    }
}
