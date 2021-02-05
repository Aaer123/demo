package com.example.demo.mapper;


import com.example.demo.domain.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StorageMapper {

    /**进货单的数据放入库存表*/

    void addStorageshop(Storage storage);


    /**
    *
    * 查询库存单中的客户编号、商品款号
    *
    */
    Storage findStorage(@Param("userid") int userid, @Param("bookshopid") String bookshopid);


    void updateStorageshop(Storage storage);
}