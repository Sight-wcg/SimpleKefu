package com.chen.simplekefu.service;

import com.chen.simplekefu.entity.Message;

import java.util.List;

/**
 * @author chen
 * @create 2020-04-24-16:39
 */
public interface MessageService {
    /**
     * 查找所有留言
     * @return
     */
    List<Message> findAllMessage();

    /**
     * 根据id删除留言
     * @param id
     */
    void deleteMessage(Integer id);

    /**
     * 更改状态
     * @param id
     * @param status
     */
    void changeStatus(Integer id,Integer status);

    /**
     * 添加留言
     * @param message
     */
    void insertMessage(Message message);


}
