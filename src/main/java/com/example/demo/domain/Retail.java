package com.example.demo.domain;

import lombok.*;

import java.util.Date;

/**
 * 零售单
 * */
/*@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter*/
public class Retail {

    //零售单据号
    private String lsdbh;

    //商品款号
    private String bookshopid;

    //商品名字
    private String bookname;

    //商品年份
    private Date bookage;

    //商品类别
    private String booklb;

    //数量
    private Integer jhsl;

    //金额
    private double jhje;

    //总数量
    private Integer tszsl;

    //总金额
    private double tszje;

    public Retail() {
    }

    public Retail(String lsdbh, String bookshopid, String bookname, Date bookage, String booklb, Integer jhsl, double jhje) {
        this.lsdbh = lsdbh;
        this.bookshopid = bookshopid;
        this.bookname = bookname;
        this.bookage = bookage;
        this.booklb = booklb;
        this.jhsl = jhsl;
        this.jhje = jhje;
        this.tszsl = tszsl;
        this.tszje = tszje;
    }

    public String getLsdbh() {
        return lsdbh;
    }

    public void setLsdbh(String lsdbh) {
        this.lsdbh = lsdbh;
    }

    public String getBookshopid() {
        return bookshopid;
    }

    public void setBookshopid(String bookshopid) {
        this.bookshopid = bookshopid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Date getBookage() {
        return bookage;
    }

    public void setBookage(Date bookage) {
        this.bookage = bookage;
    }

    public String getBooklb() {
        return booklb;
    }

    public void setBooklb(String booklb) {
        this.booklb = booklb;
    }

    public Integer getJhsl() {
        return jhsl;
    }

    public void setJhsl(Integer jhsl) {
        this.jhsl = jhsl;
    }

    public double getJhje() {
        return jhje;
    }

    public void setJhje(double jhje) {
        this.jhje = jhje;
    }

    public Integer getTszsl() {
        return tszsl;
    }

    public void setTszsl(Integer tszsl) {
        this.tszsl = tszsl;
    }

    public double getTszje() {
        return tszje;
    }

    public void setTszje(double tszje) {
        this.tszje = tszje;
    }

    @Override
    public String toString() {
        return "Retail{" +
                "lsdbh='" + lsdbh + '\'' +
                ", bookshopid='" + bookshopid + '\'' +
                ", bookname='" + bookname + '\'' +
                ", bookage=" + bookage +
                ", booklb='" + booklb + '\'' +
                ", jhsl=" + jhsl +
                ", jhje=" + jhje +
                ", tszsl=" + tszsl +
                ", tszje=" + tszje +
                '}';
    }
}
