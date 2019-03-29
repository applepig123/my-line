package com.yh.line.chat.service;

import com.yh.line.common.domain.ChatRoom;
import com.yh.line.common.domain.ChatRoomUser;
import com.yh.line.common.pojo.User;
import com.yh.line.redis.redis.RedisService;
import com.yh.line.common.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yanghua on 2019/3/26.
 */
@Service
public class RoomService {

    @Autowired
    private RedisService redisService;

    @Autowired
    private UserService userService;

    public ChatRoom getChatRoomById(String id){
        return redisService.getValue(id, ChatRoom.class);
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
