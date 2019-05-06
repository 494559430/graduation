package com.qdu.mapper;

import com.qdu.bean.Shopitemtype;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopitemtypeMapper {
    int deleteByPrimaryKey(Integer typeid);

    int insert(Shopitemtype record);

    int insertSelective(Shopitemtype record);

    Shopitemtype selectByPrimaryKey(Integer typeid);

    int updateByPrimaryKeySelective(Shopitemtype record);

    int updateByPrimaryKey(Shopitemtype record);

    List<Shopitemtype> getList();

    int insertParent(Shopitemtype record);
}