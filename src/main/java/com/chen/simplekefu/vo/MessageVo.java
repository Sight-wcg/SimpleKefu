package com.chen.simplekefu.vo;

import com.chen.simplekefu.entity.ChatMsg;

/**
 * @author chen
 * @create 2020-05-15-14:30
 */
public class MessageVo {
    private String type;
    private ChatMsg data;

    public MessageVo() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ChatMsg getData() {
        return data;
    }

    public void setData(ChatMsg data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MessageVo{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
