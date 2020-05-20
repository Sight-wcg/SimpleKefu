package com.chen.simplekefu.controller;

import com.chen.simplekefu.entity.Message;
import com.chen.simplekefu.service.MessageService;
import com.chen.simplekefu.utils.ResultVOUtil;
import com.chen.simplekefu.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author chen
 * @create 2020-04-24-16:32
 */
@Controller
@RequestMapping("message/")
public class MessageController {

    @Autowired
    private MessageService messageService;

    /**
     * 页面
     * @return
     */
    @RequestMapping("page")
    public String page(){
        return "admin/messageInfo";
    }

    /**
     * 添加留言
     * @param message
     */
    @RequestMapping("add")
    public String addMessage(Message message,HttpServletResponse response){
        messageService.insertMessage(message);
        return "client/client";
    }

    /**
     * 查找所有留言
     * @return
     */
    @ResponseBody
    @RequestMapping("getAllMessage")
    public ResultVO getAllMessage(){
        List<Message> messageList = messageService.findAllMessage();
        return ResultVOUtil.success(messageList);
    }

    /**
     * 根据id删除留言
     * @param id
     */
    @RequestMapping("deleteMessage")
    public void deleteMessage(Integer id, HttpServletResponse resp){
        messageService.deleteMessage(id);
    }

    /**
     * 更改留言状态
     * @param id
     * @param status
     */
    @RequestMapping("changeStatus")
    public void changeStatus(@RequestParam("id") Integer id, @RequestParam("status") Integer status, HttpServletResponse resp){
        messageService.changeStatus(id,status);
    }
}
