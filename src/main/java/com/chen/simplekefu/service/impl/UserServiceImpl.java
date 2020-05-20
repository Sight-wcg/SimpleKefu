package com.chen.simplekefu.service.impl;

import com.chen.simplekefu.dao.UserDao;
import com.chen.simplekefu.entity.User;
import com.chen.simplekefu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * @author chen
 * @create 2020-04-22-17:30
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 查询所有用户
     *
     * @return
     */
    @Override
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    @Override
    public User findUserById(Integer id) {
        return userDao.findUserById(id);
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @Override
    public Integer insertUser(User user) {
        //用户注册时间
        user.setRegtime((int) (System.currentTimeMillis() / 1000));
        //默认离线状态
        user.setOnline(0);
        //FIXME 临时方案，layui开关闭合不传值. 如果status为 NULL ,就设置为0
        if(user.getStatus() == null){
            user.setStatus(0);
        }
        return userDao.insertUser(user);
    }

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    @Override
    public Integer updataUser(User user) {
        //FIXME 临时方案，layui开关闭合不传值. 如果status为 NULL ,就设置为0
        if(user.getStatus() == null){
            user.setStatus(0);
        }
        return userDao.updataUser(user);
    }

    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     */
    @Override
    public Integer deleteUserById(Integer id) {
        return userDao.deleteUserById(id);
    }

    /**
     * 根据账号和密码查询用户
     *
     * @param account
     * @param password
     * @return
     */
    @Override
    public User findUserByAccountAndPassword(String account, String password) {
        return userDao.findUserByAccountAndPassword(account,password);
    }

    /**
     * 随机获取一名在线客服
     *
     * @return
     */
    @Override
    public User getOnlineUser() {
        List<User> userList = userDao.getOnlineUser();
        if(userList.size() > 0){
            Random random = new Random();
            int n = random.nextInt(userList.size());
            return userList.get(n);
        }else {
            return null;
        }
    }
}
