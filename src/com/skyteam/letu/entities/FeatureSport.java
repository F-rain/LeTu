package com.skyteam.letu.entities;

/**
 * 景点实体类
 * Created by rick- on 2017/4/27.
 */
public class FeatureSport {
    private String CityID;
    private String FeatureName;
    private int FeatureLevel;
    private String FeatureSummary;

    public String getCityID() {
        return CityID;
    }

    public void setCityID(String cityID) {
        CityID = cityID;
    }

    public String getFeatureName() {
        return FeatureName;
    }

    public void setFeatureName(String featureName) {
        FeatureName = featureName;
    }

    public int getFeatureLevel() {
        return FeatureLevel;
    }

    public void setFeatureLevel(int featureLevel) {
        FeatureLevel = featureLevel;
    }

    public String getFeatureSummary() {
        return FeatureSummary;
    }

    public void setFeatureSummary(String featureSummary) {
        FeatureSummary = featureSummary;
    }
}
