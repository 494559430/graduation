package com.qdu.bean;

public class Salebill {
    private Integer saleid;

    private Integer shopid;

    private Integer itemid;

    private Integer itemtype;

    private Integer salenum;

    private Double saleprice;

    private String saledate;

    public Integer getSaleid() {
        return saleid;
    }

    public void setSaleid(Integer saleid) {
        this.saleid = saleid;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public Integer getItemtype() {
        return itemtype;
    }

    public void setItemtype(Integer itemtype) {
        this.itemtype = itemtype;
    }

    public Integer getSalenum() {
        return salenum;
    }

    public void setSalenum(Integer salenum) {
        this.salenum = salenum;
    }

    public Double getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(Double saleprice) {
        this.saleprice = saleprice;
    }

    public String getSaledate() {
        return saledate;
    }

    public void setSaledate(String saledate) {
        this.saledate = saledate == null ? null : saledate.trim();
    }
}