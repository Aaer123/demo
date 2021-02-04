package com.example.demo.service;



import com.example.demo.domain.Customer;

import java.util.List;

public interface CustomerService {

    void insert(Customer customer);

    List<Customer> selects(int id);//封装到集合，查询出来的结果放到集合当中
}
