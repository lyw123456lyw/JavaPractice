package com.yrgbw.blogservice.controller;

import com.yrgbw.blogservice.entity.User;
import com.yrgbw.blogservice.mapper.UserMapper;
import com.yrgbw.common.annotation.DataBaseSelect;
import com.yrgbw.common.annotation.ResponseResult;
import com.yrgbw.common.bean.APIResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@ResponseResult
@RestController
@Api(value = "测试")
public class UserDemoController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("test")
    @DataBaseSelect("sqlServer")
    public List<User> test(){
        List<User> users = userMapper.get();
        int i = 1/0;
        System.out.println(users);
        System.out.println("aaa");
        return users;
    }

    @GetMapping("test2")
    @DataBaseSelect("mysql")
    public APIResult<List<User>> test2(){
        List<User> users = userMapper.get2();
        System.out.println(users);
        return null;
    }
}
