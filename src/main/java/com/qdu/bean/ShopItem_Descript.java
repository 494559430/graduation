package com.qdu.bean;

/**
 * Created by 85181 on 2019/5/2.
 */
public class ShopItem_Descript {

    private Integer shopitemid;

    private Integer shopid;

    private Integer num;

    private Integer ifgrounding = 0;

    private String shopitemname;

    private Double price;

    private Integer supplierid;

    private Integer shopitemtype;

    private String descrip;

    private String ifgroundingStr;
    private String by1;
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

    public String getShopitemname() {
        return shopitemname;
    }

    public void setShopitemname(String shopitemname) {
        this.shopitemname = shopitemname;
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
        this.descrip = descrip;
    }

    public String getBy1() {
        return by1;
    }

    public void setBy1(String by1) {
        this.by1 = by1;
    }

    public String getIfgroundingStr() {
        if(ifgrounding==0){
            return "上架";
        }else if(ifgrounding==1){
            return "下架";
        }else{
            return "别想了数据库错了";
        }
    }

    public void setIfgroundingStr(String ifgroundingStr) {
        this.ifgroundingStr = ifgroundingStr;
    }

    @Override
    public String toString() {
        return "ShopItem_Descript{" +
                "shopitemid=" + shopitemid +
                ", shopid=" + shopid +
                ", num=" + num +
                ", ifgrounding=" + ifgrounding +
                ", shopitemname='" + shopitemname + '\'' +
                ", price=" + price +
                ", supplierid=" + supplierid +
                ", shopitemtype=" + shopitemtype +
                ", descrip='" + descrip + '\'' +
                ", ifgroundingStr='" + ifgroundingStr + '\'' +
                '}';
    }
}
