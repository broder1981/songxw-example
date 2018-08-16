package com.songxw.universalbox.websocket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Websocket处理器
 */
public class WebSocketHandler extends TextWebSocketHandler {

    //存放所有已建立连接的Session
    private static final ArrayList<WebSocketSession> sessionList = new ArrayList<>();

    /**
     * 当新连接建立的时候，被调用
     * 连接成功时候，会触发页面上的onOpen方法
     * @param session
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessionList.add(session);
    }

    /**
     * 当连接关闭时被调用
     * @param session
     * @param status
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessionList.remove(session);
    }

    /**
     * 传输发生错误时调用
     * @param session
     * @param exception
     * @throws Exception
     */
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if (session.isOpen()) {
            session.close();
        }
        sessionList.remove(session);
    }

    /**
     * 处理前端发送的文本信息
     * 页面调用websocket.send的时候，会调用该方法
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        this.sendMessageToAllUsers(message);
    }

    /**
     * 将消息发送给所有在线用户
     * @param message
     */
    public static void sendMessageToAllUsers(TextMessage message) {
        for (WebSocketSession session : sessionList) {
            try {
                if (session.isOpen()) {
                    session.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 将消息发送给某个特定用户
     * @param userName
     * @param message
     */
    public static void sendMessageToUser(String userName, TextMessage message) {
        for (WebSocketSession session : sessionList) {
            if (session.getAttributes().get("WEBSOCKET_USERNAME").equals(userName)) {
                try {
                    if (session.isOpen()) {
                        session.sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

}

