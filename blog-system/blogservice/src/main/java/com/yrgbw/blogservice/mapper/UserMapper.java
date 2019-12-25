package com.yrgbw.blogservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yrgbw.blogservice.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from level")
    List<User> get();
    @Select("select * from user")
    List<User> get2();

}

