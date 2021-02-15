package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

///**
// * @RestController: —————— @Controller与 @ResponseBody两个组成的，返回json——后端返回对象给前端
//*/
//@RestController
@Controller
@RequestMapping("/user")
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


    /**
     * 注册
     * 重定向：redirect:/index --- HttpServletRequest request
     */
    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String index(User user) {
        boolean save = userService.save(user);
        System.out.println(save);
        return "login";
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

    /**
     * 登录逻辑
     */
    @RequestMapping(value = "login")//请求映射
    public String login(String username, String password, Model model) {
        User user = userService.selectUser(username, password);
        if (user != null) {
            List<User> getselects = userService.getselects();
            model.addAttribute("userList", getselects);
            return "userList";
//            return "List";
            //查询用户名是否为空，如果为空返回注册页面
        } else if (userMapper.getUser(username) == null){
            System.out.println("登录失败,请先注册账号");
            return "index";
        } else {

            return "indexs";
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
         return userService.updateuser(user)?"update":"setses";

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
