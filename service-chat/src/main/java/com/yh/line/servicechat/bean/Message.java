package com.yh.line.servicechat.bean;

/**
 * Created by yanghua on 2019/3/11.
 */
public class Message {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Message() {
    }

    public Message(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                '}';
    }
}
