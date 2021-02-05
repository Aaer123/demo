package com.example.demo.controller;


import com.example.demo.domain.Role;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;


    @RequestMapping("rolein")
    public String rolein(){
        return "roleins";
    }

    @RequestMapping("roleins")
    public String roleins(Role role){
        roleService.rolein(role);
        System.out.println(role);
        return "reigit";
    }
}
