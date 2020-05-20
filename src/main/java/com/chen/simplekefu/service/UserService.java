package com.chen.simplekefu.service;

import com.chen.simplekefu.entity.User;

import java.util.List;

/**
 * @author chen
 * @create 2020-04-22-17:27
 */
public interface UserService {

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAllUser();

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User findUserById(Integer id);

    /**
     * 添加用户
     * @param user
     * @return
     */
    Integer insertUser(User user);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    Integer updataUser(User user);

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    Integer deleteUserById(Integer id);

    /**
     * 根据账号和密码查询用户
     * @param account
     * @param password
     * @return
     */
    User findUserByAccountAndPassword(String account, String password);

    /**
     * 随机获取一名在线客服
     * @return
     */
    User getOnlineUser();
}
