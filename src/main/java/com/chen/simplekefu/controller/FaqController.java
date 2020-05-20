package com.chen.simplekefu.controller;

import com.chatopera.bot.exception.ChatbotException;
import com.chen.simplekefu.service.FaqService;
import com.chen.simplekefu.utils.JsonUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

/**
 * 知识库
 * @author chen
 * @create 2020-04-28-18:54
 */
@Controller
@RequestMapping("faq/")
public class FaqController {

    /**
     * 页面
     * @return
     */
    @RequestMapping("page")
    public String page(){
        return "admin/faqInfo";
    }

    /**
     * 知识库分类页面
     */
    @Autowired
    private FaqService faqService;

    @RequestMapping("categories/page")
    public String categoriesPage(){
        return "admin/faqCategorieInfo";
    }

    @RequestMapping("chatopera")
    public String chatoperaPage(){
        return "admin/chatopera";
    }

    /**
     * 获得知识库分类信息
     * @param response
     * @throws ChatbotException
     * @throws IOException
     */
    @RequestMapping("faqcategories")
    public void faqcategories(HttpServletResponse response) throws ChatbotException, IOException {
        JSONObject result = faqService.faqcategories();
        JsonUtil.writeValue(result,response);
    }

    /**
     * 查询知识库列表
     * @param query 查询语句
     * @param response
     * @throws ChatbotException
     * @throws UnsupportedEncodingException
     * @throws MalformedURLException
     */
    @RequestMapping("faqlist")
    public void faqList(String query, HttpServletResponse response) throws ChatbotException, IOException {
        JSONObject result = faqService.faqlist(query);
        JsonUtil.writeValue(result,response);
    }
}
