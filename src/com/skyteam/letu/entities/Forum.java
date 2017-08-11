package com.skyteam.letu.entities;

/**
 * 论坛社区实体类
 * Created by rick- on 2017/4/27.
 */
public class Forum {
    private String UserID;
    private String ForumID;
    private String TextContent;
    private String ForumTime;
    private String CityName;
    private String FeatureName;
    private String LikeNum;

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getForumID() {
        return ForumID;
    }

    public void setForumID(String forumID) {
        ForumID = forumID;
    }

    public String getTextContent() {
        return TextContent;
    }

    public void setTextContent(String textContent) {
        TextContent = textContent;
    }

    public String getForumTime() {
        return ForumTime;
    }

    public void setForumTime(String forumTime) {
        ForumTime = forumTime;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }

    public String getFeatureName() {
        return FeatureName;
    }

    public void setFeatureName(String featureName) {
        FeatureName = featureName;
    }

    public String getLikeNum() {
        return LikeNum;
    }

    public void setLikeNum(String likeNum) {
        LikeNum = likeNum;
    }
}
