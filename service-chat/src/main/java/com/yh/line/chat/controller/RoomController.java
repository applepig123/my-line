package com.yh.line.chat.controller;

import com.yh.line.chat.bean.ResponseJson;
import com.yh.line.chat.constant.ResponseStatus;
import com.yh.line.chat.service.RoomService;
import com.yh.line.common.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yanghua on 2019/3/26.
 */
@Controller
@RequestMapping("room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @ResponseBody
    @RequestMapping(value = "join", method = RequestMethod.GET)
    public ResponseJson joinRoom(@RequestParam("userId") String userId, @RequestParam("roomId") String roomId) {
        ResponseJson responseJson = new ResponseJson();
        try {
            roomService.join(roomId, userId);
            responseJson.setMessage(ResponseStatus.Success.getMessage()).setStatus(ResponseStatus.Success.getStatus());
        } catch (NotFoundException e) {
            responseJson.setStatus(ResponseStatus.NotFound.getStatus()).setMessage(ResponseStatus.NotFound.getMessage());
        }
        return responseJson;
    }
}
