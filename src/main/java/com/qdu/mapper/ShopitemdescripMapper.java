package com.qdu.mapper;

import com.qdu.bean.ShopItem_Descript;

import com.qdu.bean.Shopitemdescrip;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopitemdescripMapper {
    int deleteByPrimaryKey(Integer shopitemid);

    int insert(Shopitemdescrip record);

    int insertSelective(Shopitemdescrip record);

    Shopitemdescrip selectByPrimaryKey(Integer shopitemid);

    int updateByPrimaryKeySelective(Shopitemdescrip record);

    int updateByPrimaryKey(Shopitemdescrip record);

    List<ShopItem_Descript> getList(ShopItem_Descript shopitem_descript);

    ShopItem_Descript selectByPrimaryKey2(Integer shopitemid,Integer shopid);

    List<ShopItem_Descript> checkNum();
}