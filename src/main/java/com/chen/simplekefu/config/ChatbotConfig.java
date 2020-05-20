package com.chen.simplekefu.config;

import com.chen.simplekefu.dao.ChatbotDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author chen
 * @create 2020-04-28-0:06
 */

@Component
public class ChatbotConfig {

    private String clientId; //机器人id
    private String secret;   //机器人密钥
    private Boolean status;  //机器人状态

    /**
     * 不允许直接创建实例
     */
    private ChatbotConfig() {
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ChatbotConfig{" +
                "clientId='" + clientId + '\'' +
                ", secret='" + secret + '\'' +
                ", status=" + status +
                '}';
    }
}
