package com.chen.simplekefu.entity;

/**
 * @author chen
 * @create 2020-04-22-21:07
 */
public class Message {
    private Integer id;  //留言id
    private String username; //姓名
    private String phone;  //手机
    private String email;  //电子邮箱
    private String content; //留言内容
    private Integer status; //留言状态 0未处理 1已处理

    public Message() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                ", status=" + status +
                '}';
    }
}
