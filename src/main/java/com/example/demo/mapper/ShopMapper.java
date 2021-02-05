package com.example.demo.mapper;


import com.example.demo.domain.Shop;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShopMapper {

    boolean ShopAdd(Shop shop);//增加
}
