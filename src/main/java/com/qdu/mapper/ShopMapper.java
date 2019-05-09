package com.qdu.mapper;

import com.qdu.bean.Shop;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopMapper {
    int deleteByPrimaryKey(Integer shopid);

    int insert(Shop record);

    int insertSelective(Shop record);

    Shop selectByPrimaryKey(Integer shopid);

    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKey(Shop record);

    List<Shop> getList(Shop shop);

}