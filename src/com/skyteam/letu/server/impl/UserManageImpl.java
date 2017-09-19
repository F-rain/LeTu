package com.skyteam.letu.server.impl;

import com.skyteam.letu.dao.ForumDao;
import com.skyteam.letu.dao.Stra_NoteDao;
import com.skyteam.letu.dao.UserDao;
import com.skyteam.letu.dao.impl.ForumDaoImpl;
import com.skyteam.letu.dao.impl.Stra_NoteDaoImpl;
import com.skyteam.letu.dao.impl.UserDaoImpl;
import com.skyteam.letu.entities.Forum;
import com.skyteam.letu.entities.Strategy;
import com.skyteam.letu.entities.TravleNote;
import com.skyteam.letu.entities.User;
import com.skyteam.letu.server.UserManage;
import com.skyteam.letu.util.Checked;

import java.util.List;

/**
 * Created by rick- on 2017/5/4.
 */
public class UserManageImpl implements UserManage {
    private UserDao userDao = new UserDaoImpl();
    private Stra_NoteDao stra_noteDao = new Stra_NoteDaoImpl();
    private ForumDao forumDao = new ForumDaoImpl();

    /**
     * 通过用户的手机号和手机唯一识别码获取用户信息
     *
     * @param UserTel （用户手机号）
     * @param meid    （用户手机唯一识别码）
     * @return User（一个用户的对象）
     */
    @Override
    public User getUser(String UserTel, String meid) {
        if (!Checked.checkTel(UserTel)) return null;
        if (!Checked.checkAndroidID(meid)) return null;
        return userDao.getUser(UserTel, meid);
    }

    /**
     * 通过用户手机号，手机唯一识别码和密码获取用户信息
     *
     * @param UserTel  （用户手机号）
     * @param Password （用户密码）
     * @param meid     （用户手机唯一识别码）
     * @return User（一个用户的对象）
     */
    @Override
    public User getUser(String UserTel, String Password, String meid) {
        if (!Checked.checkTel(UserTel)) return null;
        if (!Checked.checkAndroidID(meid)) return null;
        if (Password.length() < 6) return null;
        return userDao.getUser(UserTel, Password, meid);
    }

    /**
     * 通过用户手机号和用户手机唯一识别码创建用户
     *
     * @param UserTel
     * @param meid
     * @return
     */
    @Override
    public User setUser(String UserTel, String Password, String meid) {
        if (!Checked.checkTel(UserTel)) return null;
        if (!Checked.checkAndroidID(meid)) return null;
        if (Password.length()<6) return null;
        return userDao.setUser(UserTel, Password, meid);
    }

    /**
     * 获取指定用户攻略内容列表
     *
     * @param UserID （状态码 0代表编辑中 1代表已完成 2代表已发布）
     * @return 返回List<Strategy>
     */
    @Override
    public List<Strategy> getStrategyList(String UserID) {
        if (UserID == null || UserID.equals("")) return null;
        return stra_noteDao.getStrategyList(UserID);
    }

    /**
     * 获取指定用户游记内容列表
     *
     * @param UserID （状态码 0代表编辑中 1代表已完成 2代表已发布）
     * @return 返回List<TravleNote>
     */
    @Override
    public List<TravleNote> getTravleNoteList(String UserID) {
        if (UserID == null || UserID.equals("")) return null;
        return stra_noteDao.getTravleNoteList(UserID);
    }

    /**
     * 获取指定用户论坛动态列表
     *
     * @param UserID
     * @return
     */
    @Override
    public List<Forum> getForumList(String UserID) {
        if (UserID == null || UserID.equals("")) return null;
        return forumDao.getForumList(UserID);
    }

    /**
     * 获取用户关注的人的列表
     *
     * @param UserID （用户ID）
     * @return List<User>（一组用户对象）
     */
    @Override
    public List<User> getConcernedUser(String UserID) {
        return userDao.getConcernedUser(UserID);
    }

    /**
     * 获取用户收藏的攻略
     *
     * @param UserID （用户ID）
     * @return List<Strategy>（一组攻略对象）
     */
    @Override
    public List<Strategy> getUserCollectStrategy(String UserID) {
        return userDao.getUserCollectStrategy(UserID);
    }

    /**
     * 获取用户收藏的游记
     *
     * @param UserID （用户ID）
     * @return List<TravleNote> （一组游记对象）
     */
    @Override
    public List<TravleNote> getUserCollectNote(String UserID) {
        return userDao.getUserCollectNote(UserID);
    }

    /**
     * 更新用户全部信息
     *
     * @param user
     * @return
     */
    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    /**
     * 更新用户昵称
     *
     * @param UserID
     * @param UserName
     * @return
     */
    @Override
    public boolean updateUserName(String UserID, String UserName) {
        return userDao.updateUserName(UserID, UserName);
    }

    /**
     * 更新用户手机号
     *
     * @param UserID
     * @param UserTel
     * @return
     */
    @Override
    public boolean updateUserTel(String UserID, String UserTel) {
        if (!Checked.checkTel(UserTel)) return false;
        return userDao.updateUserTel(UserID, UserTel);
    }

    /**
     * 更新用户密码
     *
     * @param UserID
     * @param Password
     * @return
     */
    @Override
    public boolean updateUserPassword(String UserID, String Password) {
        return userDao.updateUserPassword(UserID, Password);
    }
}
