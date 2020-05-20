package com.chen.simplekefu.service.impl;

import com.chatopera.bot.exception.ChatbotException;
import com.chen.simplekefu.dao.ChatbotDao;
import com.chen.simplekefu.entity.Chatbot;
import com.chen.simplekefu.service.ChatbotService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;

/**
 * @author chen
 * @create 2020-04-28-0:38
 */
@Service
public class ChatbotServiceImpl implements ChatbotService {

    @Autowired
    private ChatbotDao chatbotDao;

    /**
     * 更新机器人信息
     * @param chatbot
     */
    @Override
    public void updateChatbot(Chatbot chatbot) {
        if(chatbot.getStatus() == null){
            chatbot.setStatus(0);
        }
        chatbotDao.updateChatbot(chatbot);
    }

    /**
     * 获取机器人信息
     *
     * @return
     */
    @Override
    public Chatbot getChatbot() {
        return chatbotDao.getChatbot();
    }

    /**
     * 和机器人对话
     *
     * @param userid 用户唯一标识
     * @param text
     * @return
     */
    @Override
    public JSONObject conversation(String userid, String text) throws ChatbotException, MalformedURLException {
        String clientId = chatbotDao.getChatbot().getClientId();
        String secret = chatbotDao.getChatbot().getSecret();
        com.chatopera.bot.sdk.Chatbot chatbot = new com.chatopera.bot.sdk.Chatbot(clientId,secret);
        return chatbot.conversation(userid,text);
    }
}
