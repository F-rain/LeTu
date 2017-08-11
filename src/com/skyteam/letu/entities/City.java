package com.skyteam.letu.entities;

/**
 * 城市实体类
 * Created by rick- on 2017/4/27.
 */
public class City {
    private String CityID;
    private String CityName;
    private String Summary;

    public String getCityID() {
        return CityID;
    }

    public void setCityID(String cityID) {
        CityID = cityID;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }
}
