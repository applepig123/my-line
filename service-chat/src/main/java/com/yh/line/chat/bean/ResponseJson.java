package com.yh.line.chat.bean;

/**
 * Created by yanghua on 2019/3/26.
 */
public class ResponseJson {

    private String status;

    private String message;

    private String detail;

    private Object data;

    public String getStatus() {
        return status;
    }

    public ResponseJson setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseJson setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public ResponseJson setData(Object data) {
        this.data = data;
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public ResponseJson setDetail(String detail) {
        this.detail = detail;
        return this;
    }
}
