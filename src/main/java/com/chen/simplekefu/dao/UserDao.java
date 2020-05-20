package com.chen.simplekefu.dao;

import com.chen.simplekefu.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author chen
 * @create 2020-04-22-15:36
 */
@Mapper
public interface UserDao {
    /**
     * 查询所有用户
     * @return 返回所有用户信息
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
     * @param user 用户
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
     * 获取所有在线客服，不包括管理员，禁用状态用户
     * @return
     */
    List<User> getOnlineUser();
}
