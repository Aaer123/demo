package com.example.demo.service.impl;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
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
                userMapper.updaters(user);
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
        System.out.println(username);
        return user;
    }

    @Override
    public List<User> getselects() {
        List<User> userList = userMapper.genuflect();
        return userList;
    }

    @Override
    public List<User> selecte(String username) {
        List<User> userList = userMapper.selected(username);
        return userList;
    }

    @Override
    public boolean delete(String username) {
        //查询到用户名不为空
        if (userMapper.getUser(username)!=null){
            //删除用户
            userMapper.delete(username);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean getPasswords(String password) {
        boolean passwords = userMapper.getPasswords(password);
        return passwords;
    }
}
