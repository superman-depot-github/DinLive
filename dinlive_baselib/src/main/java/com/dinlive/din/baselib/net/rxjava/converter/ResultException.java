package com.dinlive.din.baselib.net.rxjava.converter;

/**
 * Created by superman on 2019/6/28.
 */
public class ResultException extends RuntimeException {
    private int code = -1;
    private String message;

    public ResultException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
