package com.qdu.service.impl;

import com.qdu.bean.Shopitemtype;
import com.qdu.mapper.ShopitemtypeMapper;
import com.qdu.service.ShopItemTyppeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 85181 on 2019/4/6.
 */
@Service
public class ShopItemTypeServiceImpl implements ShopItemTyppeService {

    @Resource
    private ShopitemtypeMapper mapper;

    @Override
    public List<Shopitemtype> getList(){
        return mapper.getList();
    }

    @Override
    public int insertParent(Shopitemtype shopitemtype) {
        return mapper.insertParent(shopitemtype);
    }

    @Override
    public int insertSon(Shopitemtype shopitemtype) {
        return mapper.insert(shopitemtype);
    }

    @Override
    public void update(Shopitemtype shopitemtype) {
        mapper.updateByPrimaryKey(shopitemtype);
    }

}
