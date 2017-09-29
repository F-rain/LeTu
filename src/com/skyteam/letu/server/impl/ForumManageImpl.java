package com.skyteam.letu.server.impl;

import com.skyteam.letu.dao.ForumDao;
import com.skyteam.letu.dao.LeaveWordDao;
import com.skyteam.letu.dao.impl.ForumDaoImpl;
import com.skyteam.letu.dao.impl.LeaveWordDaoImpl;
import com.skyteam.letu.entities.Forum;
import com.skyteam.letu.entities.LeaveWord;
import com.skyteam.letu.server.ForumManage;

import java.util.List;

/**
 * Created by rick- on 2017/5/4.
 */
public class ForumManageImpl implements ForumManage {
    private ForumDao forumDao = new ForumDaoImpl();
    private LeaveWordDao leaveWordDao = new LeaveWordDaoImpl();

    /**
     * 获取论坛动态列表
     *
     * @return
     */
    @Override
    public List<Forum> getForumList() {
        return forumDao.getForumList();
    }

    /**
     * 获取单个动态信息
     *
     * @param ForumID
     * @return
     */
    @Override
    public Forum getForum(String ForumID) {
        return forumDao.getForum(ForumID);
    }

    /**
     * 添加一条动态
     *
     * @param forum
     * @return
     */
    @Override
    public String setForum(Forum forum) {
        return forumDao.setForum(forum);
    }

    /**
     * 删除该用户的一条动态
     *
     * @param UserID
     * @param ForumID
     * @return
     */
    @Override
    public boolean delForum(String UserID, String ForumID) {
        //后期进行用户ID和动态里包含的用户ID相匹配

        return forumDao.delForum(ForumID);
    }

    /**
     * 获取论坛动态的留言评论
     *
     * @param ForumID
     * @return
     */
    @Override
    public List<LeaveWord> getForumLeaveWords(String ForumID) {
        return leaveWordDao.getForumLeaveWords(ForumID);
    }

    /**
     * 向一条论坛动态添加一条评论信息
     *
     * @param ForumID
     * @param leaveWord
     * @return
     */
    @Override
    public boolean setForumLeaveWord(String ForumID, LeaveWord leaveWord) {
        return leaveWordDao.setForumLeaveWord(ForumID, leaveWord);
    }
}
