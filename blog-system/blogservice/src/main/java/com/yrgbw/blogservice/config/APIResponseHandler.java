package com.yrgbw.blogservice.config;

import com.yrgbw.blogservice.interceptor.ResponseResultInterceptor;
import com.yrgbw.common.annotation.ResponseResult;
import com.yrgbw.common.commonresult.APIResult;
import com.yrgbw.common.commonresult.Result;
import com.yrgbw.common.enums.ResponseStatus;
import com.yrgbw.common.exception.DefaultErrorResult;
import com.yrgbw.common.utils.JsonUtil;
import com.yrgbw.common.utils.RequestContextHolderUtil;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import javax.servlet.http.HttpServletRequest;

/**
 * ResponseBodyAdvice: 针对所有以@ResponseBody的参数做处理
 */
@ControllerAdvice
public class APIResponseHandler implements ResponseBodyAdvice<Object> {
    /**
     *supports方法是用来判断哪些返回值是需要做统一格式处理的。可通过请求头中加上一个header来处理该类请求不需要封装
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        HttpServletRequest request = RequestContextHolderUtil.getRequest();
        ResponseResult responseResultAnn = (ResponseResult) request.getAttribute(ResponseResultInterceptor.RESPONSE_RESULT);
        return responseResultAnn != null;
    }

    /**
     *
     * @param body 从接口中返回的数据
     * @param returnType ？？？
     * @param selectedContentType  ？？？
     * @param selectedConverterType ？？？
     * @return 处理后的返回值
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        //获取到在拦截器中设置的注解对象
        ResponseResult responseResultAnn = (ResponseResult) RequestContextHolderUtil.getRequest().getAttribute(ResponseResultInterceptor.RESPONSE_RESULT);
        //获取拦截器放在域对象的值
        Class<? extends Result> resultClazz = responseResultAnn.value();
        //判断是否是目标类(APIResult)的父类
        if (resultClazz.isAssignableFrom(APIResult.class)) {
            //判断body是否是异常默认返回值
            if (body instanceof DefaultErrorResult) {
                //返回异常返回值
                DefaultErrorResult defaultErrorResult  = (DefaultErrorResult) body;
                return defaultErrorResult;
            } else if (body instanceof String) {
                return JsonUtil.object2Json(APIResult.success(body));
            }
            //返回成功返回值
            return APIResult.success(body);
        }
        return body;
    }

    /**
     *
     * @param @ExceptionHandler 改注解是指定拦截哪一种类型的异常，拦截到该异常之后
     * 通过{@link DefaultErrorResult 异常返回类}将拦截到的异常做统一封装处理
     * 在beforeBodyWrite方法中会做处理。统一了接口异常状态的返回
     */
    @ResponseBody
    @ExceptionHandler({RuntimeException.class})
    public DefaultErrorResult runtimeExceptionHandler(RuntimeException e){
        return DefaultErrorResult.failure(ResponseStatus.PARAM_NO_ZERO, e, HttpStatus.BAD_REQUEST);
    }

    private boolean isAjaxRequest(HttpServletRequest request) {
        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    }

}
