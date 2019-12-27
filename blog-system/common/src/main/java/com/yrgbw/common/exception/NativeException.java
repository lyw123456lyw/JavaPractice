package com.yrgbw.common.exception;

import lombok.Data;

@Data
public class NativeException extends RuntimeException {
    private DefaultErrorResult defaultErrorResult;

    public NativeException(DefaultErrorResult defaultErrorResult){
        super("error code: " + defaultErrorResult.getCode() + " error message " + defaultErrorResult.getMessage());
        this.defaultErrorResult = defaultErrorResult;
    }

    public DefaultErrorResult getErrorInfo(){
        return defaultErrorResult;
    }

}
