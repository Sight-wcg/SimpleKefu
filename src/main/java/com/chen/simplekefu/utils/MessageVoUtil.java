package com.chen.simplekefu.utils;

import com.chen.simplekefu.entity.ChatMsg;
import com.chen.simplekefu.vo.MessageVo;

/**
 * @author chen
 * @create 2020-05-15-14:32
 */
public class MessageVoUtil {

    //普通消息对象封装
    public static MessageVo chatMessage(ChatMsg chatMsg){
        MessageVo messageVo = new MessageVo();
        messageVo.setType("chatMessage");
        messageVo.setData(chatMsg);
        return messageVo;
    }

    //连接消息对象封装
    public static MessageVo connect(ChatMsg chatMsg){
        MessageVo messageVo = new MessageVo();
        messageVo.setType("connect");
        messageVo.setData(chatMsg);
        return messageVo;
    }

    //ping
    public static MessageVo ping(){
        MessageVo messageVo = new MessageVo();
        messageVo.setType("ping");
        return messageVo;
    }
}
