package com.chen.simplekefu.entity;

/**
 * @author chen
 * @create 2020-04-28-15:45
 */
public class Chatbot {
    private Integer id;
    private String clientId;  //机器人id
    private String secret;   //机器人密钥
    private Integer status;  //机器人状态

    public Chatbot() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Chatbot{" +
                "id=" + id +
                ", clientId='" + clientId + '\'' +
                ", secret='" + secret + '\'' +
                ", status=" + status +
                '}';
    }
}
