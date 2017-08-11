package com.skyteam.letu.server;

import com.skyteam.letu.entities.Strategy;
import com.skyteam.letu.entities.TravleNote;
import com.skyteam.letu.entities.User;

import java.util.List;

/**
 * 普通用户管理
 * Created by rick- on 2017/5/3.
 */
public interface UserManage {
    /**
     * 通过用户的手机号和手机唯一识别码获取用户信息
     * @param UserTel（用户手机号）
     * @param meid（用户手机唯一识别码）
     * @return User（一个用户的对象）
     */
    public User getUser(String UserTel, String meid);

    /**
     * 通过用户手机号，手机唯一识别码和密码获取用户信息
     * @param UserTel（用户手机号）
     * @param Password（用户密码）
     * @param meid（用户手机唯一识别码）
     * @return User（一个用户的对象）
     */
    public User getUser(String UserTel, String Password, String meid);

    /**
     * 通过用户手机号和用户手机唯一识别码创建用户
     * @param UserTel
     * @param meid
     * @return
     */
    public User setUser(String UserTel, String Password, String meid);

    /**
     * 获取用户关注的人的列表
     * @param UserID（用户ID）
     * @return List<User>（一组用户对象）
     */
    public List<User> getConcernedUser(String UserID);

    /**
     * 获取用户收藏的攻略
     * @param UserID（用户ID）
     * @return List<Strategy>（一组攻略对象）
     */
    public List<Strategy> getUserCollectStrategy(String UserID);

    /**
     * 获取用户收藏的游记
     * @param UserID（用户ID）
     * @return List<TravleNote> （一组游记对象）
     */
    public List<TravleNote> getUserCollectNote(String UserID);

    /**
     * 更新用户全部信息
     * @param user
     * @return
     */
    public boolean updateUser(User user);

    /**
     * 更新用户昵称
     * @param UserID
     * @param UserName
     * @return
     */
    public boolean updateUserName(String UserID, String UserName);

    /**
     * 更新用户手机号
     * @param UserID
     * @param UserTel
     * @return
     */
    public boolean updateUserTel(String UserID, String UserTel);

    /**
     * 更新用户密码
     * @param UserID
     * @param Password
     * @return
     */
    public boolean updateUserPassword(String UserID, String Password);
}
