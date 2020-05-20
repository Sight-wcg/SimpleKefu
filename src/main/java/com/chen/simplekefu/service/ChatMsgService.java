package com.chen.simplekefu.service;

import com.chen.simplekefu.entity.ChatMsg;

import java.util.List;

/**
 * @author chen
 * @create 2020-05-11-23:04
 */
public interface ChatMsgService {
    /**
     * 添加聊天记录
     */
    public void insertChatMsg(ChatMsg chatMsg);

    /**
     * 查找聊天记录
     * @param toid
     * @param fromid
     * @return
     */
    public List<ChatMsg> getChatMsg(Integer toid,Integer fromid);

    public List<ChatMsg> getChats();
}
