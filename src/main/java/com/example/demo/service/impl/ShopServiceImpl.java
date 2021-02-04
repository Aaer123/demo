package com.example.demo.service.impl;


import com.example.demo.domain.Shop;
import com.example.demo.mapper.ShopMapper;
import com.example.demo.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ShopServiceImpl implements ShopService {


    @Autowired
    private ShopMapper shopMapper;

    @Override
    public void ShopAdd(Shop shop) {
        shopMapper.ShopAdd(shop);
    }
}
