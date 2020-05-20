package com.chen.simplekefu.service.impl;

import com.chen.simplekefu.dao.ChatMsgDao;
import com.chen.simplekefu.entity.ChatMsg;
import com.chen.simplekefu.service.ChatMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chen
 * @create 2020-05-11-23:56
 */
@Service
public class ChatMsgServiceImpl implements ChatMsgService {

    @Autowired
    private ChatMsgDao chatMsgDao;
    /**
     * 添加聊天记录
     *
     * @param chatMsg
     */
    @Override
    public void insertChatMsg(ChatMsg chatMsg) {
        chatMsg.setSendtime(System.currentTimeMillis() / 1000);
        chatMsgDao.insertChatMsg(chatMsg);
    }

    /**
     * 查找聊天记录
     *
     * @param toid
     * @param fromid
     * @return
     */
    @Override
    public List<ChatMsg> getChatMsg(Integer toid, Integer fromid) {
        return chatMsgDao.getChatMsg(toid,fromid);
    }

    @Override
    public List<ChatMsg> getChats(){

        return chatMsgDao.getChats();
    }
}
