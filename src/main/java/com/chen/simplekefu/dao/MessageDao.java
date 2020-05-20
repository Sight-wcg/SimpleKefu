package com.chen.simplekefu.dao;

import com.chen.simplekefu.entity.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author chen
 * @create 2020-04-24-16:40
 */
@Mapper
public interface MessageDao {

    /**
     * 添加留言
     * @param message
     * @return
     */
    void insertMessage(Message message);

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
     * 更改留言状态
     * @param id
     * @param status
     */
    void changeStatus(Integer id,Integer status);
}
