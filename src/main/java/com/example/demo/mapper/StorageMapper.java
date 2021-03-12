package com.example.demo.mapper;


import com.example.demo.domain.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StorageMapper {

    /**进货单的数据放入库存表
     *
     * @param storage
     */
    void addStorageshop(Storage storage);

    /**查询库存单中的客户编号、商品款号
     *
     * @param userid
     * @param bookshopid
     * @return
     */
    Storage findStorage(@Param("userid") int userid, @Param("bookshopid") String bookshopid);

    /**更新数量
     *
     * @param storage
     */
    void updateStorageshop(Storage storage);

    /**查询库存单的商品款号
     *
     * @param bookshopid
     * @return
     */
    Storage fibd(String bookshopid);
}