package com.chen.simplekefu.controller;

import com.chen.simplekefu.entity.Visitor;
import com.chen.simplekefu.service.VisitorService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * @author chen
 * @create 2020-05-14-14:40
 */
@Controller
@RequestMapping("visitor/")
public class VisitorController {

    @Autowired
    private VisitorService visitorService;
    /**
     *添加访客信息并写入cookie
     */
    @ResponseBody
    @PostMapping("addVisitor")
    public Visitor addVisitor(Visitor visitor, HttpServletResponse response) throws UnsupportedEncodingException {
        Visitor visitInfo = visitorService.addVisitor(visitor);
        JSONObject jsonObject = new JSONObject(visitInfo);
        Cookie cookie = new Cookie("visitInfo",java.net.URLEncoder.encode(jsonObject.toString(),"UTF-8"));
        cookie.setPath("/");
        cookie.setMaxAge(3600);
        response.addCookie(cookie);
        return visitInfo;
    }

    /**
     * 获取访客信息
     * @return
     */
    @ResponseBody
    @RequestMapping("getVisitor")
    public Visitor getVisitor(Integer id){
        return visitorService.getVisitor(id);
    }
}
