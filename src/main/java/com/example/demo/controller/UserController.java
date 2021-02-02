package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

///**
// * @RestController: —————— @Controller与 @ResponseBody两个组成的，返回json——后端返回对象给前端·
//*/
//@RestController
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index",method = RequestMethod.POST)
    public String index(User user){
        userService.save(user);
        System.out.println(user);
        return "login";
    }

    //跳转登录页面方法
    @RequestMapping("logins")
    public String logins(){
        return "login";
    }

    @RequestMapping(value = "login")
    public String login(String username,String password){
        User user = userService.selectUser(username, password);
        if (user!=null){
            return "List";
        }else{
            System.out.println("登录失败,请先注册账号");
            return "index";
        }
    }
    @RequestMapping(value = "update")
    public String Uqdate(String username){
        userService.updateuser(username);
        return "update";
    }
}
