package com.yh.line.common.domain;

import com.yh.line.common.pojo.User;

/**
 * Created by yanghua on 2019/3/26.
 */
public class ChatRoomUser {

    private Long id;

    private String nickname;

    private String avatar;

    public ChatRoomUser() {
    }

    public ChatRoomUser(User user) {
        this.id = user.getId();
        this.nickname = user.getNickname();
        this.avatar = user.getAvatar();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
