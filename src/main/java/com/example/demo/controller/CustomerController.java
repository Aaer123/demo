package com.example.demo.controller;


import com.example.demo.domain.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    private CustomerService customerService;

    @RequestMapping("inserts")
    public String inserts(){
        return "insert";
    }

    @RequestMapping("insert")
    public String insert(Customer customer){
        customerService.insert(customer);
        System.out.println(customer);
        return "insertt";
    }

/*    @RequestMapping("selects")
    public String selects(int id){
        Customer customer = customerService.selects(id);
        int userid = customer.getUserid();
        String kuser = customer.getKuser();
        String ktelphone = customer.getKtelphone();
        String khlb = customer.getKhlb();
        String khemial = customer.getKhemial();
        String khagt = customer.getKhagt();
        Date kcreatetime = customer.getKcreatetime();
        System.out.println(userid);
        System.out.println(customer);
        return "toselects";*

 */

    @RequestMapping("select")
    public String select(){
       return "selects";
    }

//    @ResponseBody//直接返回json
    @RequestMapping("selects")
    public ModelAndView selects(int userid) {
        List<Customer> customerList = customerService.selects(userid);
        System.out.println(customerList);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("customerList",customerList);
        modelAndView.setViewName("customerList");
        return modelAndView;
    }

}
