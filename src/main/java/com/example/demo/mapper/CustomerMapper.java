package com.example.demo.mapper;



import com.example.demo.domain.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {

    void insert(Customer customer);

    List<Customer> selects(int userid);//根据客户id查询客户信息
}
