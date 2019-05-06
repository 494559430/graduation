package com.qdu.bean;

public class Shopitem {
    private Integer shopitemid;

    private Integer shopid;

    private Integer num;

    private Integer ifgrounding;

    private String by1;

    private String by2;

    public Integer getShopitemid() {
        return shopitemid;
    }

    public void setShopitemid(Integer shopitemid) {
        this.shopitemid = shopitemid;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getIfgrounding() {
        return ifgrounding;
    }

    public void setIfgrounding(Integer ifgrounding) {
        this.ifgrounding = ifgrounding;
    }

    public String getBy1() {
        return by1;
    }

    public void setBy1(String by1) {
        this.by1 = by1 == null ? null : by1.trim();
    }

    public String getBy2() {
        return by2;
    }

    public void setBy2(String by2) {
        this.by2 = by2 == null ? null : by2.trim();
    }
}