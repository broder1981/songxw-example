package com.songxw.universalbox.websocket;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.TextMessage;

@RestController
public class WebSocketController {

    //测试页面 http://localhost:8080/websocketPage
    @RequestMapping(value = "/websocketPage")
    public ModelAndView websocketPage () {
        ModelAndView modelAndView = new ModelAndView ();
        modelAndView.setViewName("websocket/websocket_demo.html");
        return modelAndView;
    }

    @RequestMapping(value = "/servicePush")
    public void servicePush () {
        for (int i = 0; i < 100; i++) {
            TextMessage message = new TextMessage("" + i);
            WebSocketHandler.sendMessageToAllUsers(message);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
