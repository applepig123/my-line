package com.yh.line.chat.service;

import com.yh.line.chat.data.exception.NotFoundException;
import com.yh.line.chat.data.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yanghua on 2019/3/26.
 */
@Service
public class RoomService {

    @Autowired(required = false)
    private ChatRoomService chatRoomService;

    public void joinRoom(String roomId, String userId) throws NotFoundException {
        chatRoomService.join(roomId, userId);
    }
}
