package com.example.demo.controller;


import com.example.demo.domain.Shop;
import com.example.demo.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shop")
public class ShopController {

    //注入shopService层
    @Autowired
    private ShopService shopService;


    @RequestMapping("Add")
    public String Add(){
        return "shopAdd";
    }

    //添加
    @RequestMapping("shopAdd")
    public String shopAdd(Shop shop) {
       return shopService.ShopAdd(shop)?"Adds":"Addss";
    }
}
