package com.dinlive.din.baselib.net.result;
/**
 * Created by superman on 2019/6/28.
 */
public class HttpRespResult <D>{
    private String message;
    private Integer code;
    private D data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String msg) {
        this.message = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HttpRespResult{" +
                "msg='" + message + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}
