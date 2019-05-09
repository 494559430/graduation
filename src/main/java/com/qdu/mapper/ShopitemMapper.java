package com.qdu.mapper;

import com.qdu.bean.Shopitem;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public interface ShopitemMapper {
    int insert(Shopitem record);

    int insertSelective(Shopitem record);


    void updateShopItem(Shopitem shopitem);
}