package com.chen.simplekefu.entity;

/**
 * @author chen
 * @create 2020-04-22-15:38
 */
public class User {
    private Integer id; //用户id
    private String account;  //用户账号
    private String username; //用户姓名
    private String password; //用户密码
    private Integer regtime; //注册时间
    private Integer auth; //权限 1.管理员  2. 客服
    private Integer online; //是否在线 0.离线 1.在线
    private Integer status; //用户状态 0.禁用 1.启用

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRegtime() {
        return regtime;
    }

    public void setRegtime(Integer regtime) {
        this.regtime = regtime;
    }

    public Integer getAuth() {
        return auth;
    }

    public void setAuth(Integer auth) {
        this.auth = auth;
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", regtime=" + regtime +
                ", auth=" + auth +
                ", online=" + online +
                ", status=" + status +
                '}';
    }
}
