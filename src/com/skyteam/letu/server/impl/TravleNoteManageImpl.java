package com.skyteam.letu.server.impl;

import com.skyteam.letu.dao.LeaveWordDao;
import com.skyteam.letu.dao.Stra_NoteDao;
import com.skyteam.letu.dao.impl.LeaveWordDaoImpl;
import com.skyteam.letu.dao.impl.Stra_NoteDaoImpl;
import com.skyteam.letu.entities.LeaveWord;
import com.skyteam.letu.entities.TravleNote;
import com.skyteam.letu.server.TravleNoteManage;

import java.util.List;

/**
 * Created by rick- on 2017/5/4.
 */
public class TravleNoteManageImpl implements TravleNoteManage {
    private Stra_NoteDao stra_noteDao = new Stra_NoteDaoImpl();
    private LeaveWordDao leaveWordDao = new LeaveWordDaoImpl();

    /**
     * 获取游记内容列表
     * @param Status （状态码 0代表编辑中 1代表已完成 2代表已发布）
     * @return 返回List<TravleNote>
     */
    @Override
    public List<TravleNote> getTravleNoteList(int Status) {
        return stra_noteDao.getTravleNoteList(Status);
    }

    /**
     * 获取单个游记内容
     * @param Status （状态码 0代表编辑中 1代表已完成 2代表已发布）
     * @param NoteID （游记ID）
     * @return 返回TravleNote对象
     */
    @Override
    public TravleNote getTravleNote(String NoteID, int Status) {
        return stra_noteDao.getTravleNote(NoteID, Status);
    }

    /**
     * 添加游记内容
     * @param Status （状态码 0代表编辑中 1代表已完成 2代表已发布）
     * @param travleNote （游记对象）
     * @return 返回一个布尔值
     */
    @Override
    public boolean setTravleNote(TravleNote travleNote, int Status) {
        return stra_noteDao.setTravleNote(travleNote, Status);
    }

    /**
     * 发布一个游记
     *
     * @param NoteID （游记ID）
     * @return 返回一个布尔值
     */
    @Override
    public boolean issueTravleNote(String NoteID) {
        return stra_noteDao.issueTravleNote(NoteID);
    }

    /**
     * 更新一个游记
     *
     * @param NoteID
     * @param travleNote
     * @return
     */
    @Override
    public boolean updateTravleNote(String NoteID, TravleNote travleNote) {
        return stra_noteDao.updateTravleNote(NoteID, travleNote);
    }

    /**
     * 删除该用户的一个游记
     *
     * @param UserID
     * @param NoteID （游记ID）
     * @return 返回一个布尔值
     */
    @Override
    public boolean delTravleNote(String UserID, String NoteID) {
        //后期进行用户ID和旅游游记的用户ID进行匹配判断

        return stra_noteDao.delTravleNote(NoteID);
    }

    /**
     * 获取游记的留言评论
     *
     * @param NoteID
     * @return
     */
    @Override
    public List<LeaveWord> getNoteLeaveWords(String NoteID) {
        return leaveWordDao.getNoteLeaveWords(NoteID);
    }

    /**
     * 向一条游记添加一条评论信息
     *
     * @param NoteID
     * @param leaveWord
     * @return
     */
    @Override
    public boolean setNoteLeaveWord(String NoteID, LeaveWord leaveWord) {
        return leaveWordDao.setNoteLeaveWord(NoteID, leaveWord);
    }
}
