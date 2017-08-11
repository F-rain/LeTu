package com.skyteam.letu.entities;

/**
 * 攻略实体类
 * Created by rick- on 2017/4/27.
 */
public class Strategy {
    private String UserID;
    private String StrategyId;
    private String TextContent;
    private String StrategyTime;
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

    public String getStrategyId() {
        return StrategyId;
    }

    public void setStrategyId(String strategyId) {
        StrategyId = strategyId;
    }

    public String getTextContent() {
        return TextContent;
    }

    public void setTextContent(String textContent) {
        TextContent = textContent;
    }

    public String getStrategyTime() {
        return StrategyTime;
    }

    public void setStrategyTime(String strategyTime) {
        StrategyTime = strategyTime;
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
