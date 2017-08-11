package com.skyteam.letu.entities;

/**
 * 留言评论实体类
 * Created by rick- on 2017/4/28.
 */
public class LeaveWord {
    private String ID;
    private String FromUserID;
    private String ToUserID;
    private String Content;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFromUserID() {
        return FromUserID;
    }

    public void setFromUserID(String fromUserID) {
        FromUserID = fromUserID;
    }

    public String getToUserID() {
        return ToUserID;
    }

    public void setToUserID(String toUserID) {
        ToUserID = toUserID;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
