package com.qdu.mapper;

import com.qdu.bean.Notice;
import com.qdu.bean.NoticeShop;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface NoticeShopMapper {
    int insert(NoticeShop record);
    void updateRead(Notice notice);
    int insertSelective(NoticeShop record);



    int delete(Map<String, Object> map);

    int unreadNum(int shopid);
}