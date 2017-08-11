package com.skyteam.letu.entities;

/**
 * 用户实体类
 * Created by rick- on 2017/4/27.
 */
public class User {
    private String UserID;
    private String UserName;
    private String UserTel;
    private String Meid;
    private boolean UserSex;
    private String UserBirth;

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserTel() {
        return UserTel;
    }

    public void setUserTel(String userTel) {
        UserTel = userTel;
    }

    public String getMeid() {
        return Meid;
    }

    public void setMeid(String meid) {
        Meid = meid;
    }

    public boolean isUserSex() {
        return UserSex;
    }

    public void setUserSex(boolean userSex) {
        UserSex = userSex;
    }

    public String getUserBirth() {
        return UserBirth;
    }

    public void setUserBirth(String userBirth) {
        UserBirth = userBirth;
    }
}
