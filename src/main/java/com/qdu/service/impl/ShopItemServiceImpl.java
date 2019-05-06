package com.qdu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qdu.bean.ShopItem_Descript;
import com.qdu.bean.Shopitemdescrip;
import com.qdu.mapper.ShopitemMapper;
import com.qdu.mapper.ShopitemdescripMapper;
import com.qdu.service.ShopItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 85181 on 2019/4/21.
 */
@Service
public class ShopItemServiceImpl  implements ShopItemService{
    @Autowired
    ShopitemMapper shopitemMapper;

    @Autowired
    ShopitemdescripMapper shopitemdescripMapper;


    @Override
    public Map<String, Object> getList(Integer page, Integer rows, ShopItem_Descript shopitem_descript) {

        List<ShopItem_Descript> list = shopitemdescripMapper.getList(shopitem_descript);
        PageHelper.startPage(page,rows);
        PageInfo<ShopItem_Descript> pi = new PageInfo<>(list);
        Map<String, Object> result = new HashMap<>();
        result.put("rows", list);
        result.put("total", pi.getTotal());
        return  result;
    }

    @Override
    public Shopitemdescrip getItemDetail() {
        return null;
    }

    @Override
    public Shopitemdescrip getDetail(Integer shopitemid) {
        return shopitemdescripMapper.selectByPrimaryKey(shopitemid);
    }

    @Override
    public int update(Shopitemdescrip shopitemdescrip) {
        int i = shopitemdescripMapper.updateByPrimaryKey(shopitemdescrip);
        return i;
    }

    @Override
    public int add(Shopitemdescrip shopitemdescrip) {
        return shopitemdescripMapper.insert(shopitemdescrip);
    }


}
