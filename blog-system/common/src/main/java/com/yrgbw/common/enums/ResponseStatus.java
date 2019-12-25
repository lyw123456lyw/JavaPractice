package com.yrgbw.common.enums;

public enum ResponseStatus {
    SUCCESS(200,"请求成功"),
    INTERNAL_SERVER_ERROR(500,"服务器内部异常"),
    PARAM_ERROR(400,"参数有误");

    private Integer code;
    private String message;
    ResponseStatus(Integer code, String message){
        this.code = code;
        this.message = message;
    }

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

    @Override
    public String toString() {
        return "HttpStatus{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
