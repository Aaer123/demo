package com.example.demo.service.impl;


import com.example.demo.domain.Customer;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceimpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public void insert(Customer customer) {
        customerMapper.insert(customer);
    }

    @Override
    public List<Customer> selects(int id) {
        List<Customer> customerList = customerMapper.selects(id);
        return customerList;
    }
}
