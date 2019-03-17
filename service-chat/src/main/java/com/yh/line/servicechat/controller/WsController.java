package com.yh.line.servicechat.controller;

import com.yh.line.servicechat.bean.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
