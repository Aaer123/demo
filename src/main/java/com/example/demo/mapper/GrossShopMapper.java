package com.example.demo.mapper;



import com.example.demo.domain.GrossShop;

import java.util.List;

public interface GrossShopMapper {

    /**
     * grossShop :进货单
     */
    void grosshopadd(GrossShop grossShop);

    /**
    *
    *根据客户id查询进货单
    *
    */
    List<GrossShop> grosshopselect(int userid);
}

