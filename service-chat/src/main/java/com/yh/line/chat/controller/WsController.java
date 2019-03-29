package com.yh.line.chat.controller;

import com.yh.line.chat.bean.BroadMessage;
import com.yh.line.common.domain.ChatRoom;
import com.yh.line.common.domain.ChatRoomUser;
import com.yh.line.common.pojo.User;
import com.yh.line.chat.service.RoomService;
import com.yh.line.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

/**
 * Created by yanghua on 2019/3/10.
 */
@Controller
public class WsController {

    @Value("${websocket.broker.broad}")
    private String chatRoomPrefix;

    @Value("${websocket.broker.user}")
    private String userPrefix;

    @Autowired
    private RoomService roomService;

    @Autowired
    private UserService userService;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("toAll")
    public void sendTopic(BroadMessage message) {
        ChatRoom chatRoom = roomService.getChatRoomById(message.getDest());
        if(chatRoom != null) {
            ChatRoomUser fromUser = null;
            Set<ChatRoomUser> users = chatRoom.getUsers();
            Optional<ChatRoomUser> first = users.stream().filter(user -> user.getId().equals(message.getFromUserId())).findFirst();
            if(first.isPresent()) {
                fromUser = first.get();
            } else {
                User user = userService.getUserById(Long.valueOf(message.getFromUserId()));
                if(user != null) {
                    fromUser = new ChatRoomUser(user);
                }
            }
            message.setFromUser(fromUser);
            message.setCreateDate(new Date());
            simpMessagingTemplate.convertAndSend(chatRoomPrefix + "/" + message.getDest(), message);
        }
    }
}
