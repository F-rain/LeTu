package com.skyteam.letu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库操作类
 * Created by rick- on 2016/12/3.
 */
public class DBUtil {

    public static Connection getConn(){
        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://118.89.236.245:2418/letu?useUnicode=true&characterEncoding=utf-8&useSSL=false", "frain", "FRAIN!0251515971zm");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return conn;
    }

    /**
     * 关闭数据库连接
     */
    public static void closeConn(Connection conn, Statement statement){
        try {
            if (statement != null){
                statement.close();
            }
            if (conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
