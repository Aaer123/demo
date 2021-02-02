package com.example.demo.mapper;


import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

       //注册
       void save(User user);

       //登录
       User selectUser(@Param("username") String username,@Param("password") String password);

       //修改密码
       void updateuser(String username);

       //查询用户
       User getUser(String username);

}
