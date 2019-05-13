package com.qdu.service.impl;

import com.qdu.bean.Notice;
import com.qdu.bean.NoticeShop;
import com.qdu.mapper.NoticeMapper;
import com.qdu.mapper.NoticeShopMapper;
import com.qdu.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/5/13.
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    NoticeMapper mapper1;
    @Autowired
    NoticeShopMapper mapper2;
    @Override
    public boolean addNotice(Notice notice) {
        try {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            notice.setDate(sdf.format(date));
           mapper1.insert(notice);
            NoticeShop noticeShop = new NoticeShop();
            noticeShop.setId(notice.getId());
            noticeShop.setIsread(0);
            String[] shopids = notice.getShopids().split(",");
            for (String shopid : shopids) {
                noticeShop.setShopid(Integer.valueOf(shopid));
                mapper2.insert(noticeShop);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public List<Notice> getAllNotice() {
        return null;
    }

    @Override
    public List<Notice> getNoticeByShopid1(int shopid) {
        return null;
    }

    @Override
    public List<Notice> getNoticeByShopid2(int shopid) {
        return null;
    }
}
