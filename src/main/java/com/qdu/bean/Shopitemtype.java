package com.qdu.bean;

public class Shopitemtype {
    private Integer typeid;

    private String typename;

    private Integer parentid;

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    @Override
    public String toString() {
        return "Shopitemtype{" +
                "typeid=" + typeid +
                ", typename='" + typename + '\'' +
                ", parentid=" + parentid +
                '}';
    }
}