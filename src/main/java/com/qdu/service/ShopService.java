package com.qdu.service;

import com.qdu.bean.Shop;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by 85181 on 2019/5/8.
 */

public interface ShopService {
    Map<String,Object> getList(Integer page, Integer rows,Shop shop);

    int addShop(Shop shop);

    int update(Shop shop);

    Shop getShopById(int shopid);

    List<Shop> getshopList();
}
