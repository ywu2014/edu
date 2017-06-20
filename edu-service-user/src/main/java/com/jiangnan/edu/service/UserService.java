package com.jiangnan.edu.service;

import java.util.List;

import com.jiangnan.edu.entity.User;

/**
 * @author 吴叶俊
 */
public interface UserService {
    /**
     * 保存用户信息.
     * @param pmsUser
     */
    void create(User pmsUser);

    /**
     * 根据ID获取用户信息.
     * @param userId
     * @return
     */
    User getById(Long userId);

    /**
     * 根据登录名取得用户对象
     */
    User findUserByUserNo(String userNo);

    /**
     * 根据ID删除一个用户，同时删除与该用户关联的角色关联信息. type="1"的超级管理员不能删除.
     *
     * @param userId
     *            用户ID.
     */
    void deleteUserById(long userId);


    /**
     * 更新用户信息.
     * @param user
     */
    void update(User user);

    /**
     * 根据用户ID更新用户密码.
     *
     * @param userId
     * @param newPwd
     *            (已进行SHA1加密)
     */
    void updateUserPwd(Long userId, String newPwd, boolean isTrue);

    //public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap);

    List<User> listAll();
}
