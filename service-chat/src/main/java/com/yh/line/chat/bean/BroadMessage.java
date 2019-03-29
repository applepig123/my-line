package com.yh.line.chat.bean;


import com.yh.line.common.domain.ChatRoomUser;

import java.util.Date;

/**
 * Created by yanghua on 2019/3/11.
 */
public class BroadMessage {
    private String dest;

    private String fromUserId;

    private ChatRoomUser fromUser;

    private String content;

    private Date createDate;

    private int type;

    public String getContent() {
        return content;
    }

    public String getDest() {
        return dest;
    }

    public BroadMessage setDest(String dest) {
        this.dest = dest;
        return this;
    }

    public ChatRoomUser getFromUser() {
        return fromUser;
    }

    public BroadMessage setFromUser(ChatRoomUser fromUser) {
        this.fromUser = fromUser;
        return this;
    }

    public BroadMessage setContent(String content) {
        this.content = content;
        return this;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public BroadMessage setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }

    public int getType() {
        return type;
    }

    public BroadMessage setType(int type) {
        this.type = type;
        return this;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public BroadMessage setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
        return this;
    }
}
