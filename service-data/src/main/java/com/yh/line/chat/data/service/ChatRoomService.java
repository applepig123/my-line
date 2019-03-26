package com.yh.line.chat.data.service;

import com.yh.line.chat.data.entity.ChatRoomUser;
import com.yh.line.chat.data.exception.NotFoundException;
import com.yh.line.chat.data.entity.ChatRoom;
import com.yh.line.chat.data.pojo.User;
import com.yh.line.chat.data.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yanghua on 2019/3/26.
 */
@Service
public class ChatRoomService {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private UserService userService;

    public ChatRoom getChatRoomById(String id){
        return new ChatRoom();
    }

    public void join(String roomId, String userId) throws NotFoundException {
        ChatRoom chatRoom = this.getChatRoomById(roomId);
        if(chatRoom == null) {
            throw new NotFoundException();
        }
        User user = userService.getUserById(Long.valueOf(userId));
        ChatRoomUser chatRoomUser = new ChatRoomUser(user);
        chatRoom.getUsers().add(chatRoomUser);
    }
}
