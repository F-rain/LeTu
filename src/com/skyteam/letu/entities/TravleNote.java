package com.skyteam.letu.entities;

/**
 * 游记实体类
 * Created by rick- on 2017/4/27.
 */
public class TravleNote {
    private String UserID;
    private String NodeID;
    private String TextContent;
    private String NoteTime;
    private String CityName;
    private String FeatureName;
    private int Status;
    private String LikeNum;

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getNodeID() {
        return NodeID;
    }

    public void setNodeID(String nodeID) {
        NodeID = nodeID;
    }

    public String getTextContent() {
        return TextContent;
    }

    public void setTextContent(String textContent) {
        TextContent = textContent;
    }

    public String getNoteTime() {
        return NoteTime;
    }

    public void setNoteTime(String noteTime) {
        NoteTime = noteTime;
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

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getLikeNum() {
        return LikeNum;
    }

    public void setLikeNum(String likeNum) {
        LikeNum = likeNum;
    }
}
