package com.example.springbootdemo.thirdtool.socket;

/**
 * @author LargerBear</ br>
 * date: 2021/3/19 10:00</br>
 * @since JDK 1.8
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * 开启WebSocket支持
 * @author zhengkai.blog.csdn.net
 */
//@Configuration
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

}

