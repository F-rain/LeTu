package com.skyteam.letu.dao;

import com.skyteam.letu.entities.LeaveWord;

import java.util.List;

/**
 * 评论内容接口
 * Created by rick- on 2017/4/28.
 */
public interface LeaveWordDao {
    /**
     * 获取论坛动态的留言评论
     * @param ForumID
     * @return
     */
    public List<LeaveWord> getForumLeaveWords(String ForumID);

    /**
     * 获取攻略的留言评论
     * @param StrategyID
     * @return
     */
    public List<LeaveWord> getStrategyLeaveWords(String StrategyID);

    /**
     * 获取游记的留言评论
     * @param NoteID
     * @return
     */
    public List<LeaveWord> getNoteLeaveWords(String NoteID);

    /**
     * 向一条论坛动态添加一条评论信息
     * @param ForumID
     * @param leaveWord
     * @return
     */
    public boolean setForumLeaveWord(String ForumID, LeaveWord leaveWord);

    /**
     * 向一条攻略添加一条评论信息
     * @param StrategyID
     * @param leaveWord
     * @return
     */
    public boolean setStrategyLeaveWord(String StrategyID, LeaveWord leaveWord);

    /**
     * 向一条游记添加一条评论信息
     * @param NoteID
     * @param leaveWord
     * @return
     */
    public boolean setNoteLeaveWord(String NoteID, LeaveWord leaveWord);
}
