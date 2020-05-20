package com.chen.simplekefu.service.impl;

import com.chen.simplekefu.dao.MessageDao;
import com.chen.simplekefu.entity.Message;
import com.chen.simplekefu.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chen
 * @create 2020-04-24-16:39
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;
    /**
     * 查找所有留言
     *
     * @return
     */
    @Override
    public List<Message> findAllMessage() {
        return messageDao.findAllMessage();
    }

    /**
     * 根据id删除留言
     *
     * @param id
     */
    @Override
    public void deleteMessage(Integer id) {
        messageDao.deleteMessage(id);
    }

    /**
     * 更改状态
     *
     * @param id
     * @param status
     */
    @Override
    public void changeStatus(Integer id, Integer status) {
        messageDao.changeStatus(id,status);
    }

    /**
     * 添加留言
     *
     * @param message
     */
    @Override
    public void insertMessage(Message message) {
        messageDao.insertMessage(message);
    }
}
