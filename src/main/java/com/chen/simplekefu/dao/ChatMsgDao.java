package com.chen.simplekefu.dao;

import com.chen.simplekefu.entity.ChatMsg;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author chen
 * @create 2020-05-16-3:46
 */
@Mapper
public interface ChatMsgDao {

    /**
     * 插入聊天信息
     * @param chatMsg
     */
    void insertChatMsg(ChatMsg chatMsg);

    /**
     * 获取聊天信息
     * @param toid
     * @param fromid
     * @return
     */
    List<ChatMsg> getChatMsg(Integer toid,Integer fromid);

    /**
     * 对话表
     * @return
     */
    List<ChatMsg> getChats();
}
