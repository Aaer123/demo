package com.example.demo.mapper;

import com.example.demo.domain.Retail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RetailMapper {

    /**
     * 添加零售单
     * @param retail
     */
    void StorageShopid(Retail retail);

    /**
     * 更新零售数量
     * @param retail
     */
    void RetailNumber(Retail retail);

    /**
     * 从零售单查询是否有这个商品
     * @param bookshopid
     * @return
     */
    Retail AddShop(String bookshopid);

    /**
     * 结算
     */
    void EmptyShopPingCart();
}
