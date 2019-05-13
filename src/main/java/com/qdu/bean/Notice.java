package com.qdu.bean;

import org.springframework.format.annotation.DateTimeFormat;

public class Notice {
    private Integer id;

    private String title;

    private String content;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private String date;

    private String shopids;
    private int shopid;
    private int isRead;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getShopids() {
        return shopids;
    }

    public void setShopids(String shopids) {
        this.shopids = shopids;
    }

    public int getShopid() {
        return shopid;
    }

    public void setShopid(int shopid) {
        this.shopid = shopid;
    }

    public int getIsRead() {
        return isRead;
    }

    public void setIsRead(int isRead) {
        this.isRead = isRead;
    }
}