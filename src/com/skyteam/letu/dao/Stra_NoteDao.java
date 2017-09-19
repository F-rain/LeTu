package com.skyteam.letu.dao;

import com.skyteam.letu.entities.Strategy;
import com.skyteam.letu.entities.TravleNote;

import java.util.List;

/**
 * 攻略游记内容接口
 * Created by rick- on 2017/4/28.
 */
public interface Stra_NoteDao {
    /**
     * 获取攻略内容列表
     * @param Status （状态码 0代表编辑中 1代表已完成 2代表已发布）
     * @return 返回List<Strategy>
     */
    public List<Strategy> getStrategyList(int Status);

    /**
     * 获取指定用户攻略内容列表
     * @param UserID （状态码 0代表编辑中 1代表已完成 2代表已发布）
     * @return 返回List<Strategy>
     */
    public List<Strategy> getStrategyList(String UserID);

    /**
     * 获取游记内容列表
     * @param Status （状态码 0代表编辑中 1代表已完成 2代表已发布）
     * @return 返回List<TravleNote>
     */
    public List<TravleNote> getTravleNoteList(int Status);

    /**
     * 获取指定用户游记内容列表
     * @param UserID （状态码 0代表编辑中 1代表已完成 2代表已发布）
     * @return 返回List<TravleNote>
     */
    public List<TravleNote> getTravleNoteList(String UserID);

    /**
     * 获取单个攻略内容
     * @param StrategyID（攻略ID）
     * @return 返回Strategy对象
     */
    public Strategy getStrategy(String StrategyID);

    /**
     * 获取单个攻略内容
     * @param StrategyID（攻略ID）
     * @param Status （状态码 0代表编辑中 1代表已完成 2代表已发布）
     * @return 返回Strategy对象
     */
    public Strategy getStrategy(String StrategyID, int Status);

    /**
     * 获取单个游记内容
     * @param NoteID（游记ID）
     * @return 返回TravleNote对象
     */
    public TravleNote getTravleNote(String NoteID);

    /**
     * 获取单个游记内容
     * @param NoteID（游记ID）
     * @param Status （状态码 0代表编辑中 1代表已完成 2代表已发布）
     * @return 返回TravleNote对象
     */
    public TravleNote getTravleNote(String NoteID, int Status);

    /**
     * 添加攻略内容
     * @param strategy（攻略对象）
     * @param Status （状态码 0代表编辑中 1代表已完成 2代表已发布）
     * @return 返回一个布尔值
     */
    public boolean setStrategy(Strategy strategy, int Status);

    /**
     * 添加游记内容
     * @param travleNote（游记对象）
     * @param Status （状态码 0代表编辑中 1代表已完成 2代表已发布）
     * @return 返回一个布尔值
     */
    public boolean setTravleNote(TravleNote travleNote, int Status);

    /**
     * 发布一个攻略
     * @param StrategyID（攻略ID）
     * @return 返回一个布尔值
     */
    public boolean issueStrategy(String StrategyID);

    /**
     * 发布一个游记
     * @param NoteID（游记ID）
     * @return 返回一个布尔值
     */
    public boolean issueTravleNote(String NoteID);

    /**
     * 更新一个攻略
     * @param StrategyID
     * @param strategy
     * @return
     */
    public boolean updateStrategy(String StrategyID, Strategy strategy);

    /**
     * 更新一个游记
     * @param NoteID
     * @param travleNote
     * @return
     */
    public boolean updateTravleNote(String NoteID, TravleNote travleNote);

    /**
     * 删除一个攻略
     * @param StrategyID（攻略ID）
     * @return 返回一个布尔值
     */
    public boolean delStrategy(String StrategyID);

    /**
     * 删除一个游记
     * @param NoteID（游记ID）
     * @return 返回一个布尔值
     */
    public boolean delTravleNote(String NoteID);
}
