package com.example.administrator.mvphero.retrofit.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/29.
 */

public class ResponseBean implements Serializable{
    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
