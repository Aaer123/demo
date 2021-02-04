package com.example.demo.service.impl;


import com.example.demo.domain.GrossShop;
import com.example.demo.mapper.GrossShopMapper;
import com.example.demo.service.GrossShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class GrossShopServiceImpl implements GrossShopService {

    //注入进货数据层
    @Autowired
    private GrossShopMapper grossShopMapper;


    //添加方法
    @Override
    public void grosshopadd(GrossShop grossShop) {
        grossShopMapper.grosshopadd(grossShop);
    }

    @Override
    public List<GrossShop> grosshopselect(int userid) {
        List<GrossShop> grossShopList = grossShopMapper.grosshopselect(userid);
        return grossShopList;
    }


}
