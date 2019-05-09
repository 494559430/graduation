package com.qdu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qdu.bean.Shop;
import com.qdu.mapper.ShopMapper;
import com.qdu.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 85181 on 2019/5/8.
 */
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    ShopMapper shopMapper;

    @Override
    public Map<String, Object> getList(Integer page, Integer rows,Shop shop) {
        List<Shop> list = shopMapper.getList(shop);
        PageHelper.startPage(page,rows);
        PageInfo<Shop> pi = new PageInfo<>(list);
        Map<String, Object> result = new HashMap<>();
        result.put("rows", list);
        result.put("total", pi.getTotal());
        return result;
    }

    @Override
    public int addShop(Shop shop) {
        int i = shopMapper.insert(shop);

        return i;
    }

    @Override
    public int update(Shop shop) {
        return shopMapper.updateByPrimaryKey(shop);
    }

    @Override
    public Shop getShopById(int shopid) {
        return shopMapper.selectByPrimaryKey(shopid);
    }

    @Override
    public List<Shop> getshopList() {
        Shop shop = new Shop();
        return shopMapper.getList(shop);
    }
}
