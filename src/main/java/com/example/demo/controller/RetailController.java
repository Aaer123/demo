package com.example.demo.controller;

import com.example.demo.domain.Retail;
import com.example.demo.domain.Storage;
import com.example.demo.mapper.RetailMapper;
import com.example.demo.service.RetailService;
import com.example.demo.service.StorageService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
//@ResponseBody
@RequestMapping("retail")
public class RetailController {

    //注入零售业务层
    @Autowired
    private RetailService retailService;

    //注入库存业务层
    @Autowired
    private StorageService storageService;

    //注入零售数据层
    @Autowired
    private RetailMapper retailMapper;


    /**
     *
     * 新建零售表
     *   一、查询商品从库存表中查询商品
     * 例如：查询6200031，存在商品取出商品明细，库存数量有188件;
     * ①、库存表中查询存在商品;
     *     1.取出商品明细;
     *     2.把商品信息添加到零售单;
     *     3.在库存中取出一件商品，并且结算，库存数量减少1件，实时库存就剩下187件;
     *     4.付款了，库存数量减少;
     * ②、库存表中查询不存在商品;
     *     1、返回商品不存在的页面
     */
    @RequestMapping("StoragesShopid")
    public String StoragesShopid(){
        return "Storgesshopids";
    }
    @RequestMapping("Storgesshopids")
    public String Storgesshopids(String bookshopid,Integer jhsl){
        if (bookshopid==null||"".equals(bookshopid)){
            return "shopNot";
        }
        //库存单查询商品款号
        Storage fibd = storageService.fibd(bookshopid);
        //商品不为空
        if (fibd!=null) {
            //商品款号
            String fibdBookshopid = fibd.getBookshopid();
            //名称
            String fibdBookname = fibd.getBookname();
            //年份
            Date fibdBookage = fibd.getBookage();
            //类别
            String fibdBooklb = fibd.getBooklb();
            /*//数量
            Integer fibdJhsl = fibd.getJhsl();*/

            //进货价
            double fibdJhje = fibd.getJhje();
            //零售单查询商品
            Retail retail = retailService.AddShop(bookshopid);
            /**
             * ①、商品为空，增加商品；商品不为空，零售单录入存在同样商品数量累加
             * ②、商品款号不一致，另外一个商品，重新创建一条记录
             */
           if (retail == null) {
                //添加零售单
                retailMapper.StorageShopid(new Retail(null, fibdBookshopid, fibdBookname, fibdBookage, fibdBooklb, jhsl, fibdJhje));
                System.out.println("当前商品已经成功添加到零售单");
                return "acess";
            }else{
                retail.setJhsl(retail.getJhsl() + jhsl);
                retailService.RetailNumber(retail);
            }
        }
        return "acess";
    }
}
