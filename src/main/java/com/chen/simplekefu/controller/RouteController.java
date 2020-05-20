package com.chen.simplekefu.controller;

import com.chen.simplekefu.entity.Visitor;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * @author chen
 * @create 2020-04-22-10:23
 */
@Controller
public class RouteController {

    @RequestMapping("/index")
    public String test(){
        return "index";
    }

    @RequestMapping("client")
    public String client(){
        return "client/client";
    }

    @RequestMapping("chatbot")
    public String chatbot(HttpServletResponse response) throws UnsupportedEncodingException {
        Visitor visitor = new Visitor();
        visitor.setId(1);
        visitor.setVisitid("访客1");
        JSONObject jsonObject = new JSONObject(visitor);
        Cookie cookie = new Cookie("visitInfo",java.net.URLEncoder.encode(jsonObject.toString(),"UTF-8"));
        cookie.setPath("/");
        cookie.setMaxAge(3600);
        response.addCookie(cookie);
        return "client/chatbot";
    }
}
