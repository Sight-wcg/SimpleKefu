package com.chen.simplekefu.service;

import com.chatopera.bot.exception.ChatbotException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

/**
 * @author chen
 * @create 2020-04-28-19:02
 */
public interface FaqService {
    /**
     * 获得知识库分类信息
     * @return
     */
    JSONObject faqcategories() throws ChatbotException, MalformedURLException;

    /**
     * 查询知识库列表
     * @param query
     * @return
     * @throws MalformedURLException
     * @throws ChatbotException
     * @throws UnsupportedEncodingException
     */
    JSONObject faqlist(String query) throws MalformedURLException, ChatbotException, UnsupportedEncodingException;
}
