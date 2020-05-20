package com.chen.simplekefu.service;

import com.chatopera.bot.exception.ChatbotException;
import com.chen.simplekefu.entity.Chatbot;
import org.json.JSONObject;

import java.net.MalformedURLException;

/**
 * @author chen
 * @create 2020-04-28-0:37
 */
public interface ChatbotService {
    /**
     * 更新机器人信息
     * @param chatbot
     */
    void updateChatbot(Chatbot chatbot);

    /**
     * 获取机器人信息
     * @return
     */
    Chatbot getChatbot();

    /**
     * 和机器人对话
     * @param userid 用户唯一标识
     * @param text
     * @return
     */
    JSONObject conversation(String userid, String text) throws ChatbotException, MalformedURLException;
}
