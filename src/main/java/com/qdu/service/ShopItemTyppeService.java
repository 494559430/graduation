package com.qdu.service;

import com.qdu.bean.Shopitemtype;

import java.util.List;

/**
 * Created by 85181 on 2019/4/6.
 */
public interface ShopItemTyppeService {

     List<Shopitemtype> getList();

    int insertParent(Shopitemtype shopitemtype);

    int insertSon(Shopitemtype shopitemtype);

    void update(Shopitemtype shopitemtype);
}
