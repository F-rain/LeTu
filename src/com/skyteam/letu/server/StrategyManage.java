package com.skyteam.letu.server;

import com.skyteam.letu.entities.LeaveWord;
import com.skyteam.letu.entities.Strategy;

import java.util.List;

/**
 * 普通用户对攻略的管理
 * Created by rick- on 2017/5/3.
 */
public interface StrategyManage {
    /**
     * 获取攻略内容列表
     * @param Status （状态码 0代表编辑中 1代表已完成 2代表已发布）
     * @return 返回List<Strategy>
     */
    public List<Strategy> getStrategyList(int Status);

    /**
     * 获取单个攻略内容
     * @param StrategyID（攻略ID）
     * @param Status （状态码 0代表编辑中 1代表已完成 2代表已发布）
     * @return 返回Strategy对象
     */
    public Strategy getStrategy(String StrategyID, int Status);

    /**
     * 添加攻略内容
     * @param strategy（攻略对象）
     * @param Status （状态码 0代表编辑中 1代表已完成 2代表已发布）
     * @return 返回一个布尔值
     */
    public boolean setStrategy(Strategy strategy, int Status);

    /**
     * 发布一个攻略
     * @param StrategyID（攻略ID）
     * @return 返回一个布尔值
     */
    public boolean issueStrategy(String StrategyID);

    /**
     * 更新一个攻略
     * @param StrategyID
     * @param strategy
     * @return
     */
    public boolean updateStrategy(String StrategyID, Strategy strategy);

    /**
     * 删除该用户的一个攻略
     * @param UserID
     * @param StrategyID
     * @return
     */
    public boolean delStrategy(String UserID, String StrategyID);

    /**
     * 获取攻略的留言评论
     * @param StrategyID
     * @return
     */
    public List<LeaveWord> getStrategyLeaveWords(String StrategyID);

    /**
     * 向一条攻略添加一条评论信息
     * @param StrategyID
     * @param leaveWord
     * @return
     */
    public boolean setStrategyLeaveWord(String StrategyID, LeaveWord leaveWord);
}
