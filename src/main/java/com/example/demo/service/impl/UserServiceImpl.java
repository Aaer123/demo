package com.example.demo.service.impl;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public boolean save(User user) {
        //注册的用户名不存在，允许注册
        if (userMapper.getUser(user.getUsername())==null){
            //注册
            userMapper.save(user);
            System.out.println(user);
            //注册成功
            return true;
        }else{
            return false;
        }
    }

    @Override
    public User selectUser(String username, String password) {
        User user = userMapper.selectUser(username, password);
        return user;
    }

    @Override
    public boolean updateuser(User user) {
            //查询到该用户名，进行修改密码
            if (userMapper.getUser(user.getUsername()) != null) {
                userMapper.updateuser(user);
                System.out.println(user);
                //修改成功
                return true;
            } else {
                return false;
            }
        }
    @Override
    public User getUser(String username) {
        User user = userMapper.getUser(username);
        return user;
    }

    @Override
    public List<User> getselects() {
        List<User> userList = userMapper.getselects();
        return userList;
    }

    @Override
    public List<User> selecte(String username) {
        List<User> userList = userMapper.selecte(username);
        return userList;
    }
}
