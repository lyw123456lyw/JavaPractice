package com.yrgbw.common.bean;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class APIResult<T> {
    private Integer code;
    private String message;
    private T data;
    private long timeStamp = System.currentTimeMillis();

    public APIResult(){

    }

    public APIResult(Integer code, String message, T data){
        this.code = code;
        this.message =message;
        this.data =data;
    }

    public APIResult(T data){
        this.data = data;
    }
}
