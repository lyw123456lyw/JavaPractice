package com.yrgbw.blogservice.controller;

import com.yrgbw.blogservice.entity.User;
import com.yrgbw.blogservice.mapper.UserMapper;
import com.yrgbw.common.annotation.DataBaseSelect;
import com.yrgbw.common.bean.APIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserDemoController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("test")
    @DataBaseSelect("sqlServer")
    public List<User> test(){
        List<User> users = userMapper.get();
        System.out.println(users);
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
