package com.chen.simplekefu.service.impl;

import com.chatopera.bot.exception.ChatbotException;
import com.chatopera.bot.sdk.Chatbot;
import com.chen.simplekefu.dao.ChatbotDao;
import com.chen.simplekefu.service.FaqService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

/**
 * @author chen
 * @create 2020-04-28-19:04
 */
@Service
public class FaqServiceImpl implements FaqService {

    @Autowired
    private ChatbotDao chatbotDao;

    /**
     * 获得知识库分类信息
     *
     * @return
     */
    @Override
    public JSONObject faqcategories() throws ChatbotException, MalformedURLException {
        String clientId = chatbotDao.getChatbot().getClientId();
        String secret = chatbotDao.getChatbot().getSecret();
        Chatbot chatbot = new Chatbot(clientId,secret);
        return chatbot.faqcategories();
    }

    /**
     * 查询知识库列表
     * @param query  查询语句，关键词
     * @return
     * @throws MalformedURLException
     * @throws ChatbotException
     * @throws UnsupportedEncodingException
     */
    @Override
    public JSONObject faqlist(String query) throws MalformedURLException, ChatbotException, UnsupportedEncodingException {
        String clientId = chatbotDao.getChatbot().getClientId();
        String secret = chatbotDao.getChatbot().getSecret();
        Chatbot chatbot = new Chatbot(clientId,secret);
        return chatbot.faqlist(query,null,0,0);
    }
}
