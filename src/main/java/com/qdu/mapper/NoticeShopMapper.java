package com.qdu.mapper;

import com.qdu.bean.Notice;
import com.qdu.bean.NoticeShop;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeShopMapper {
    int insert(NoticeShop record);
    void updateRead(Notice notice);
    int insertSelective(NoticeShop record);
}