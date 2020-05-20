package com.chen.simplekefu.controller;

import com.chen.simplekefu.entity.User;
import com.chen.simplekefu.service.UserService;
import com.chen.simplekefu.utils.ResultVOUtil;
import com.chen.simplekefu.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * @author chen
 * @create 2020-04-22-15:16
 */
@Controller
@RequestMapping("user/")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户页面
     * @return
     */
    @RequestMapping("page")
    public String page(){
        return "admin/serviceInfo";
    }

    /**
     * 添加用户页面
     * @return
     */
    @RequestMapping("add/page")
    public String addPage(){
        return "admin/serviceAdd";
    }

    /**
     * 更新信息页面
     * @return
     */
    @RequestMapping("updata/page")
    public String updataPage(){
        return "admin/serviceEdit";
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @RequestMapping("updataUser")
    public String updataUser(User user){
        userService.updataUser(user);
        return "redirect:page";
    }

    /**
     * 随机获取一名在线的客服
     * @return
     */
    @ResponseBody
    @RequestMapping("getOnlineUser")
    public User getOnlineUser(){
        return userService.getOnlineUser();
    }

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("getUser")
    public User getUserById(Integer id){
        return userService.findUserById(id);
    }

    /**
     * 获取所有用户信息
     * @return
     */
    @ResponseBody
    @GetMapping("getAllUser")
    public ResultVO getAllUser(){
        List<User> userList = userService.findAllUser();
        return ResultVOUtil.success(userList);
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @RequestMapping("addUser")
    public String addUser(User user){
        userService.insertUser(user);
        return "redirect:page";
    }

    /**
     * 根据id删除用户
     * @param id
     */
    @RequestMapping("deleteUser")
    public void deleteUser(Integer id, HttpServletResponse response){
        userService.deleteUserById(id);
    }
}
