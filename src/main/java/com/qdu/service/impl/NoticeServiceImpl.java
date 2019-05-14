package com.qdu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qdu.bean.Notice;
import com.qdu.bean.NoticeShop;
import com.qdu.mapper.NoticeMapper;
import com.qdu.mapper.NoticeShopMapper;
import com.qdu.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            noticeShop.setIsread(1);
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
    public Map<String, Object> getAllNotice() {
        return null;
    }

    @Override
    public Map<String, Object> getNoticeByShopid(Integer page, Integer rows, Notice notice) {
        PageHelper.startPage(page,rows);
        List<Notice> list = mapper1.selectByShopid(notice);
        PageInfo<Notice> pi = new PageInfo<>(list);
        Map<String, Object> result = new HashMap<>();
        result.put("rows", list);
        result.put("total", pi.getTotal());
        return result;

    }

    @Override
    public Notice getNoticeById(int id) {
        return mapper1.selectByPrimaryKey(id);
    }

    @Override
    public void updateRead(int id, Integer shopId) {
        Notice notice = new Notice();
        notice.setId(id);
        notice.setShopid(shopId);
        mapper2.updateRead(notice);
    }

    @Override
    public int delete(String[] id,Integer shopid) {
        Map<String,Object> map = new HashMap<String, Object>(){
            {
                put("ids",id);
                put("shopid",shopid);
            }
        };
        return mapper2.delete(map);

    }


}
