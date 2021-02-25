package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

///**
// * @RestController: —————— @Controller与 @ResponseBody两个组成的，返回json——后端返回对象给前端
//*/
//@RestController
@Controller
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    /**
     * 注入用户业务层
     */
    @Autowired
    private UserService userService;

    /**
     * 注入用户数据层
     */
    @Autowired
    private UserMapper userMapper;


    @RequestMapping("/indexs")
    public String indexs() {
        return "index";
    }

    /**
     * 注册
     * 重定向：redirect:/index --- HttpServletRequest request
     */
    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String index(User user, String username) {
        //查询用户名
        User userServiceUser = userService.getUser(username);
        //验证用户名是否存在
        if (userServiceUser != null && userServiceUser.getUsername().length() != 0) {
            return "indes";
        } else if (userServiceUser == null) {
            boolean save = userService.save(user);
            System.out.println(save);
            return "login";
        }
        return "";
    }

    //跳转登录页面
    @RequestMapping("/logins")
    public String logins() {
        return "login";
    }

    //    返回json对象
   /* @RequestMapping("login")
    public User login(){
        User user=new User(1,"kkk","12323");
         user.setId(3);
         user.setUsername("kkkkdkkdkwd");
         user.setPassword("21312321");
         return user;
    }*/
    /**错误逻辑，不建议这样做*/
/*    @RequestMapping(value = "login")//请求映射
    public String login(String username, String password, Model model) {
        User user = userService.selectUser(username, password);
        if (user != null) {
            List<User> getselects = userService.getselects();
            model.addAttribute("userList", getselects);
            return "userList";
//            return "List";
            //查询用户名是否为空，如果为空返回注册页面
        }else if (userMapper.getUser(username) == null) {
            System.out.println("登录失败,请先注册账号");
            return "index";
        }
        return "indexs";
    }*/

    /**
     * 登录逻辑
     * && 称为逻辑与运算符。当且仅当两个操作数都为真，条件才为真。	（A && B）为假。
     * || 称为逻辑或操作符。如果任何两个操作数任何一个为真，条件为真。	（A | | B）为真。
     * ！ 称为逻辑非运算符。用来反转操作数的逻辑状态。如果条件为true，则逻辑非运算符将得到false。	！（A && B）为真。
     * @Valid
     *
     * 用户登录页面啥都不输入就返回登录页面，
     * 用户输入用户名， 数据库查到有这个用户名，密码错误，返回的是用户名或密码错误页面，
     * 用户输入账号，密码，都正确就跳转主页
     * 用户输入账号，数据库查询不到这个用户，应该返回注册页面
     *
     * 正确登录逻辑
     */
    @RequestMapping(value = "login")//请求映射
    public String login(String username, String password, Model model) {
        if (username == null || "".equals(username) || password == null || "".equals(password)){//不进行查询数据库用户名、密码,用户不输入用户名、密码的情况下返回登录页面
            return "login";
        }
          /**查询用户名*/
          User userServiceUser = userService.getUser(username);
          /**用户名不为空，查询密码进行比较*/
        if (userServiceUser != null&&userServiceUser.getPassword().equals(password)) {//查询到的密码与传进来的实体参数比较
            List<User> userList = userService.getselects();
            System.out.println(userList);
            model.addAttribute("userList", userList);
            return "userList";
            /**查询用户名为空*/
        } else if (userServiceUser == null) {
            System.out.println("登录失败,请先注册账号");
            return "index";
            /**查询用户名不为空，密码比较*/
        } else if (userServiceUser != null && !(userServiceUser.getPassword().equals(password))){//在判断密码前加!的意思:密码不等
            return "indexs";
        } else {
            return "ok";
        }
    }


        //跳转修改页面
        @RequestMapping("sets")
        public String sets() {
          return "set";
    }

        //修改密码
        @RequestMapping("set")
        public String setPasswords(User user){
         return userService.updateuser(user)?"update":"set";

    }

    @RequestMapping("findAll")
    public String findAll(){
        return "get";
    }

    @RequestMapping("get")
    public ModelAndView get(){
        List<User> userList = userService.getselects();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("userList");
        System.out.println(userList);
        return modelAndView;
    }

    @RequestMapping("findAlls")
    public String findAlls(){
        return "gets";
    }

    @RequestMapping("gets")
    public ModelAndView gets(String username){
        List<User> userList = userService.selecte(username);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("userList");
        System.out.println(userList);
        return modelAndView;
    }

    @RequestMapping("delete")
    public String delete(){
        return "deletee";
    }

    @RequestMapping("deletee")
    public String deletee(String username){
        return userService.delete(username)?"deletes":"say";
    }
}
