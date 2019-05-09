package com.qdu.bean;

/**
 * Created by 85181 on 2019/5/7.
 */
public class SalebillShow {
    double sum;
    int salenum;
    String typename;
    String name;
    String saledate;

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public int getSalenum() {
        return salenum;
    }

    public void setSalenum(int salenum) {
        this.salenum = salenum;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSaledate() {
        return saledate;
    }

    public void setSaledate(String saledate) {
        this.saledate = saledate;
    }

    @Override
    public String toString() {
        return "SalebillShow{" +
                "sum=" + sum +
                ", salenum=" + salenum +
                ", typename='" + typename + '\'' +
                ", name='" + name + '\'' +
                ", saledate='" + saledate + '\'' +
                '}';
    }
}
