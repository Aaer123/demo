package com.example.demo.mapper;


import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

       //注册
       void save(User user);

       //登录
       User selectUser(@Param("username") String username,@Param("password") String password);

       //修改密码
       void updaters(User user);

       //查询用户名
       User getUser(String username);

       //查询所有用户
       List<User> genuflect();

       //根据用户名查询
       List<User> selected(String username);

       //删除用户
       void delete(String username);

       //查询密码是否一致
       boolean getPasswords(String password);
}
