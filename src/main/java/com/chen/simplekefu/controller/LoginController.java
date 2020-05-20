package com.chen.simplekefu.controller;

import com.chen.simplekefu.entity.User;
import com.chen.simplekefu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @author chen
 * @create 2020-04-22-11:07
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param account 账号
     * @param password 密码
     * @param session session对象
     * @param model
     * @return 根据账号权限进入后台管理或客服工作台
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String account, String password, HttpSession session, Model model){
        //查找用户
        User user = userService.findUserByAccountAndPassword(account,password);
        if(user != null){
            //更改在线状态
           // userService.changeOnline();
            session.setAttribute("userInfo",user);
            if(1 == user.getAuth()){
                return "admin/admin";
            }else {
                return "service/service";
            }
        }
        model.addAttribute("msg","账号或密码错误，请重新输入");
        return "login";
    }

    /**
     * 退出登录
     * @param session session对象
     * @return 返回登录页面
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:login";
    }

    /**
     * 页面
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }
}
