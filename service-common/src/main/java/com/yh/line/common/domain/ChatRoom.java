package com.yh.line.common.domain;

import java.util.Date;
import java.util.Set;

/**
 * Created by yanghua on 2019/3/26.
 */
public class ChatRoom {

    private String id;

    private String name;

    private Set<ChatRoomUser> users;

    private Date createTime;

    private Integer count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ChatRoomUser> getUsers() {
        return users;
    }

    public void setUsers(Set<ChatRoomUser> users) {
        this.users = users;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
