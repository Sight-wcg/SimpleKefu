package com.chen.simplekefu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author chen
 * @create 2020-05-11-22:39
 */
@Configuration
public class WebSocketConfig {
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        System.out.println(">>>>>>>>>>>>启用WebSocket");
        return new ServerEndpointExporter();
    }
}
