package com.skyteam.letu.dao;

import com.skyteam.letu.entities.Forum;

import java.util.List;

/**
 * 论坛社区内容接口
 * Created by rick- on 2017/4/28.
 */
public interface ForumDao {
    /**
     * 获取论坛动态列表
     * @return
     */
    public List<Forum> getForumList();

    /**
     * 获取单个动态信息
     * @param ForumID
     * @return
     */
    public Forum getForum(String ForumID);

    /**
     * 添加一条动态
     * @param forum
     * @return
     */
    public boolean setForum(Forum forum);

    /**
     * 删除一条动态
     * @param ForumID
     * @return
     */
    public boolean delForum(String ForumID);
}
