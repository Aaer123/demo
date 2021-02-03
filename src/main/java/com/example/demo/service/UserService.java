package com.example.demo.service;

import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {

    //注册
    void save(User user);

    //登录
    User selectUser(@Param("username") String username, @Param("password") String password);

    //修改密码
    boolean updateuser(User user);

    //查询用户名
    User getUser(String username);

}
