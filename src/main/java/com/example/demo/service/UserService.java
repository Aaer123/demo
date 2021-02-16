package com.example.demo.service;

import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    //注册
    boolean save(User user);

    //登录
    User selectUser(@Param("username") String username, @Param("password") String password);

    //修改密码
    boolean updateuser(User user);

    //查询用户名
    User getUser(String username);

    //查询所有用户
    List<User> getselects();

    //根据用户名查询
    List<User> selecte(String username);

    //删除用户（根据用户名删除）
    boolean delete(String username);

    //查询密码是否一致
    boolean getPassword(String password);

}
