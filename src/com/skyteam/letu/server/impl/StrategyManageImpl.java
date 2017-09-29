package com.skyteam.letu.server.impl;

import com.skyteam.letu.dao.LeaveWordDao;
import com.skyteam.letu.dao.Stra_NoteDao;
import com.skyteam.letu.dao.impl.LeaveWordDaoImpl;
import com.skyteam.letu.dao.impl.Stra_NoteDaoImpl;
import com.skyteam.letu.entities.LeaveWord;
import com.skyteam.letu.entities.Strategy;
import com.skyteam.letu.server.StrategyManage;

import java.util.List;

/**
 * Created by rick- on 2017/5/4.
 */
public class StrategyManageImpl implements StrategyManage {
    private Stra_NoteDao stra_noteDao = new Stra_NoteDaoImpl();
    private LeaveWordDao leaveWordDao = new LeaveWordDaoImpl();

    /**
     * 获取攻略内容列表
     * @param Status （状态码 0代表编辑中 1代表已完成 2代表已发布）
     * @return 返回List<Strategy>
     */
    @Override
    public List<Strategy> getStrategyList(int Status) {
        return stra_noteDao.getStrategyList(Status);
    }

    /**
     * 获取单个攻略内容
     * @param Status （状态码 0代表编辑中 1代表已完成 2代表已发布）
     * @param StrategyID （攻略ID）
     * @return 返回Strategy对象
     */
    @Override
    public Strategy getStrategy(String StrategyID, int Status) {
        return stra_noteDao.getStrategy(StrategyID, Status);
    }

    /**
     * 添加攻略内容
     * @param Status （状态码 0代表编辑中 1代表已完成 2代表已发布）
     * @param strategy （攻略对象）
     * @return 返回一个布尔值
     */
    @Override
    public String setStrategy(Strategy strategy, int Status) {
        return stra_noteDao.setStrategy(strategy, Status);
    }

    /**
     * 发布一个攻略
     *
     * @param StrategyID （攻略ID）
     * @return 返回一个布尔值
     */
    @Override
    public boolean issueStrategy(String StrategyID) {
        return stra_noteDao.issueStrategy(StrategyID);
    }

    /**
     * 更新一个攻略
     *
     * @param StrategyID
     * @param strategy
     * @return
     */
    @Override
    public boolean updateStrategy(String StrategyID, Strategy strategy) {
        return stra_noteDao.updateStrategy(StrategyID, strategy);
    }

    /**
     * 删除该用户的一个攻略
     *
     * @param UserID
     * @param StrategyID
     * @return
     */
    @Override
    public boolean delStrategy(String UserID, String StrategyID) {
        //后期判断用户ID和攻略对象的用户ID相匹配

        return stra_noteDao.delStrategy(StrategyID);
    }

    /**
     * 获取攻略的留言评论
     *
     * @param StrategyID
     * @return
     */
    @Override
    public List<LeaveWord> getStrategyLeaveWords(String StrategyID) {
        return leaveWordDao.getStrategyLeaveWords(StrategyID);
    }

    /**
     * 向一条攻略添加一条评论信息
     *
     * @param StrategyID
     * @param leaveWord
     * @return
     */
    @Override
    public boolean setStrategyLeaveWord(String StrategyID, LeaveWord leaveWord) {
        return leaveWordDao.setStrategyLeaveWord(StrategyID, leaveWord);
    }
}
