package com.qdu.mapper;

import com.qdu.bean.NoticeShop;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeShopMapper {
    int insert(NoticeShop record);

    int insertSelective(NoticeShop record);
}