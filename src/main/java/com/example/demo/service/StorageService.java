package com.example.demo.service;


import com.example.demo.domain.Storage;

import java.util.List;

public interface StorageService {

    /**库存添加操作
     *
     * @param storage
     */
    void addStorageshop(Storage storage);


    /**库存单中查询到客户id，商品款号
     *
     * @param userid
     * @param bookshopid
     * @return
     */
    Storage findStorage(int userid,String bookshopid);


    /**更新库存数量
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
