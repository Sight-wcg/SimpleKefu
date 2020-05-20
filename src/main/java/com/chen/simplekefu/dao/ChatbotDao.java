package com.chen.simplekefu.dao;

import com.chen.simplekefu.entity.Chatbot;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author chen
 * @create 2020-04-28-15:57
 */
@Mapper
public interface ChatbotDao {
    /**
     * 获取机器人信息
     * @return
     */
    Chatbot getChatbot();

    /**
     * 更新机器人信息
     * @param chatbot
     */
    void updateChatbot(Chatbot chatbot);
}
