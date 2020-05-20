package com.chen.simplekefu.controller;

import com.chatopera.bot.exception.ChatbotException;
import com.chen.simplekefu.entity.Chatbot;
import com.chen.simplekefu.config.ChatbotConfig;
import com.chen.simplekefu.service.ChatbotService;
import com.chen.simplekefu.utils.JsonUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * @author chen
 * @create 2020-04-27-23:49
 */
@Controller
@RequestMapping("chatbot/")
public class ChatbotController {

    @Autowired
    private ChatbotService chatbotService;

    /**
     * 页面
     * @return
     */
    @RequestMapping("page")
    public String page(){
        return "admin/chatbotInfo";
    }

    /**
     *更新
     * @param chatbot
     */
    @RequestMapping("updateChatbot")
    public String updateChatbot(Chatbot chatbot) {
        chatbotService.updateChatbot(chatbot);
        return "redirect:page";
    }

    /**
     * 获取机器人信息
     * @return
     */
    @ResponseBody
    @RequestMapping("getChatbot")
    public Chatbot getChatbot(){
        return chatbotService.getChatbot();
    }

    /**
     * 和机器人对话
     */
    @RequestMapping("conversation")
    public void conversation(String userid,String text,HttpServletResponse response) throws ChatbotException, IOException {
        JSONObject result = chatbotService.conversation(userid,text);
        JsonUtil.writeValue(result,response);
    }
}
