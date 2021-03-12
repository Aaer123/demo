package com.example.demo.mapper;



import com.example.demo.domain.GrossShop;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GrossShopMapper {

    /**
     * grossShop :进货单
     */
    void grosshopadd(GrossShop grossShop);

    /**
    *根据客户id查询进货单
    */
    List<GrossShop> grosshopselect(int userid);
}

