package com.songxw.universalbox.websocket;

import com.songxw.universalbox.websocket.WebSocketHandler;
import com.songxw.universalbox.websocket.WebSocketHandshakeInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Spring WebSocket的配置，这里采用的是注解的方式
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //注册WebSocket
        String websocketUrl = "/websocket.do";//设置websocket的地址
        registry.addHandler(webSocketHandler(), websocketUrl).//注册Handler
                addInterceptors(new WebSocketHandshakeInterceptor());//注册Interceptor
        //注册SockJS，提供SockJS支持(主要是兼容ie8)
        String sockjsUrl = "/sockjs.do";//设置sockjs的地址
        registry.addHandler(webSocketHandler(), sockjsUrl).//注册Handler
                addInterceptors(new WebSocketHandshakeInterceptor()).//注册Interceptor
                withSockJS();//支持sockjs协议
    }

    @Bean
    public TextWebSocketHandler webSocketHandler() {
        return new WebSocketHandler();
    }

}

