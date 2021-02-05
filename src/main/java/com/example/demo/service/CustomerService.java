package com.example.demo.service;



import com.example.demo.domain.Customer;

import java.util.List;

public interface CustomerService {

    /**
    * 增加客户
    */
    void insert(Customer customer);

    /**
    * 查询客户
    */
    List<Customer> selects(int userid);//封装到集合，查询出来的结果放到集合当中
}
