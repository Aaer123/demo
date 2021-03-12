package com.example.demo.service;


import com.example.demo.domain.Retail;
import org.apache.ibatis.annotations.Param;

public interface RetailService {

    /**
     * 添加零售单
     *
     * @param retail
     */
    void StoragesShopid(Retail retail);

    /**
     * 更新零售单商品数量
     *
     * @param retail
     */
    void RetailNumber(Retail retail);

    /**
     * 从零售单查询是否有这个商品
     *
     * @param bookshopid
     * @return
     */
    Retail AddShop(String bookshopid);

    /**
     * 结算
     */
    void EmptyShopPingCart();
}
