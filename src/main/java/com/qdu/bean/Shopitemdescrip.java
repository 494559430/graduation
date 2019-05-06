package com.qdu.bean;


public class Shopitemdescrip {
    private Integer shopitemid;

    private String shopitemname;

    private Double price;

    private Integer supplierid;

    private Integer shopitemtype;

    private String descrip;

    private String by1;

    private String by2;

    public Integer getShopitemid() {
        return shopitemid;
    }

    public void setShopitemid(Integer shopitemid) {
        this.shopitemid = shopitemid;
    }

    public String getShopitemname() {
        return shopitemname;
    }

    public void setShopitemname(String shopitemname) {
        this.shopitemname = shopitemname == null ? null : shopitemname.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(Integer supplierid) {
        this.supplierid = supplierid;
    }

    public Integer getShopitemtype() {
        return shopitemtype;
    }

    public void setShopitemtype(Integer shopitemtype) {
        this.shopitemtype = shopitemtype;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip == null ? null : descrip.trim();
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