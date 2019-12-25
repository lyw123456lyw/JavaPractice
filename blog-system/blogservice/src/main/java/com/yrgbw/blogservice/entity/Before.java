package com.yrgbw.blogservice.entity;

import lombok.Data;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
@Data
public class Before {
    MethodParameter methodParameter;
    Class<? extends HttpMessageConverter<?>> aClass;
    MediaType mediaType;
}
