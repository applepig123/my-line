package com.yh.line.chat.controller;

import com.yh.line.chat.bean.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

/**
 * Created by yanghua on 2019/3/10.
 */
@Controller
public class WsController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("toAll")
    @SendTo("/topic/info")
    public Message sendTopic(Message request) {
        System.out.println(request.toString());
        Message response = new Message();
        response.setContent("yes, i send you a response");
        System.out.println(response.toString());
        return response;
    }
}
