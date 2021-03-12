package com.example.demo.service.impl;

import com.example.demo.domain.Retail;
import com.example.demo.mapper.RetailMapper;
import com.example.demo.service.RetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RetailServiceimpl implements RetailService {

    @Autowired
    private RetailMapper retailMapper;

    @Override
    public void StoragesShopid(Retail retail) {
        retailMapper.StorageShopid(retail);
    }

    @Override
    public void RetailNumber(Retail retail) {
        retailMapper.RetailNumber(retail);
    }

    @Override
    public Retail AddShop(String bookshopid) {
        Retail retail = retailMapper.AddShop(bookshopid);
        return retail;
    }

    @Override
    public void EmptyShopPingCart() {
        retailMapper.EmptyShopPingCart();
    }
}

