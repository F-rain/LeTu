package com.skyteam.letu.server;

import com.skyteam.letu.entities.LeaveWord;
import com.skyteam.letu.entities.TravleNote;

import java.util.List;

/**
 * Created by rick- on 2017/5/3.
 */
public interface TravleNoteManage {
    /**
     * 获取游记内容列表
     * @param Status （状态码 0代表编辑中 1代表已完成 2代表已发布）
     * @return 返回List<TravleNote>
     */
    public List<TravleNote> getTravleNoteList(int Status);

    /**
     * 获取单个游记内容
     * @param NoteID（游记ID）
*      @param Status （状态码 0代表编辑中 1代表已完成 2代表已发布）
     * @return 返回TravleNote对象
     */
    public TravleNote getTravleNote(String NoteID, int Status);

    /**
     * 添加游记内容
     * @param travleNote（游记对象）
     * @param Status （状态码 0代表编辑中 1代表已完成 2代表已发布）
     * @return 返回一个布尔值
     */
    public String setTravleNote(TravleNote travleNote, int Status);

    /**
     * 发布一个游记
     * @param NoteID（游记ID）
     * @return 返回一个布尔值
     */
    public boolean issueTravleNote(String NoteID);

    /**
     * 更新一个游记
     * @param NoteID
     * @param travleNote
     * @return
     */
    public boolean updateTravleNote(String NoteID, TravleNote travleNote);

    /**
     * 删除该用户的一个游记
     * @param NoteID（游记ID）
     * @return 返回一个布尔值
     */
    public boolean delTravleNote(String UserID, String NoteID);

    /**
     * 获取游记的留言评论
     * @param NoteID
     * @return
     */
    public List<LeaveWord> getNoteLeaveWords(String NoteID);

    /**
     * 向一条游记添加一条评论信息
     * @param NoteID
     * @param leaveWord
     * @return
     */
    public boolean setNoteLeaveWord(String NoteID, LeaveWord leaveWord);
}
