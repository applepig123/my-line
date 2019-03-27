package com.yh.line.chat.constant;

/**
 * Created by yanghua on 2019/3/26.
 */
public enum ResponseStatus {
    Success("200", "成功"),
    NotFound("404", "没有找到");

    ResponseStatus(String status, String message) {
        this.status = status;
        this.message = message;
    }

    private String status;

    private String message;

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
