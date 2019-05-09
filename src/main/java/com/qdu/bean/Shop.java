package com.qdu.bean;

public class Shop {
    private Integer shopid;

    private String shopname;

    private String shopaddress;

    private String shopperson;

    private String shopphone;

    private String shopstate;

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname == null ? null : shopname.trim();
    }

    public String getShopaddress() {
        return shopaddress;
    }

    public void setShopaddress(String shopaddress) {
        this.shopaddress = shopaddress == null ? null : shopaddress.trim();
    }

    public String getShopperson() {
        return shopperson;
    }

    public void setShopperson(String shopperson) {
        this.shopperson = shopperson == null ? null : shopperson.trim();
    }

    public String getShopphone() {
        return shopphone;
    }

    public void setShopphone(String shopphone) {
        this.shopphone = shopphone == null ? null : shopphone.trim();
    }

    public String getShopstate() {
        return shopstate;
    }

    public void setShopstate(String shopstate) {
        this.shopstate = shopstate == null ? null : shopstate.trim();
    }
}