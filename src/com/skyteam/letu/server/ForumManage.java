package com.skyteam.letu.server;

import com.skyteam.letu.entities.Forum;
import com.skyteam.letu.entities.LeaveWord;

import java.util.List;

/**
 * 普通用户对论坛动态的管理
 * Created by rick- on 2017/5/3.
 */
public interface ForumManage {
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
    public String setForum(Forum forum);

    /**
     * 删除该用户的一条动态
     * @param ForumID
     * @param UserID
     * @return
     */
    public boolean delForum(String UserID, String ForumID);

    /**
     * 获取论坛动态的留言评论
     * @param ForumID
     * @return
     */
    public List<LeaveWord> getForumLeaveWords(String ForumID);

    /**
     * 向一条论坛动态添加一条评论信息
     * @param ForumID
     * @param leaveWord
     * @return
     */
    public boolean setForumLeaveWord(String ForumID, LeaveWord leaveWord);
}
