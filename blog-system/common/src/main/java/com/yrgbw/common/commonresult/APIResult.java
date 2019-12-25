package com.yrgbw.common.commonresult;

import com.yrgbw.common.enums.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * API接口同一返回格式
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class APIResult implements Result {
    private static final long serialVersionUID = 874200365941306385L;
    private Integer code;
    private String message;
    private Object data;
    public static APIResult success() {
        APIResult result = new APIResult();
        result.setCode(ResponseStatus.SUCCESS.getCode());
        return result;
    }

    public static  APIResult success(Object data) {
        APIResult result = new APIResult();
        result.setCode(ResponseStatus.SUCCESS.getCode());
        result.setData(data);
        return result;
    }

    public static APIResult failure(ResponseStatus resultCode) {
        APIResult result = new APIResult();
        result.setCode(resultCode.getCode());
        return result;
    }

    public static APIResult failure(ResponseStatus resultCode, Object data) {
        APIResult result = new APIResult();
        result.setCode(resultCode.getCode());
        result.setData(data);
        return result;
    }

    public static APIResult failure(String message) {
        APIResult result = new APIResult();
        result.setCode(ResponseStatus.PARAM_ERROR.getCode());
        result.setMessage(message);
        return result;
    }

    private void setResultCode(ResponseStatus code) {
        this.code = code.getCode();
        this.message = code.getMessage();
    }

}
