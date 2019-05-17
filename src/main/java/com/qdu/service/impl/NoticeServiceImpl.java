package com.qdu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qdu.bean.*;
import com.qdu.mapper.NoticeMapper;
import com.qdu.mapper.NoticeShopMapper;
import com.qdu.mapper.ShopitemdescripMapper;
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
    @Autowired
    ShopitemdescripMapper mapper3;
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
    public Map<String, Object> getAllNotice(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<Notice> list = mapper1.getAllNotice();
        PageInfo<Notice> pi = new PageInfo<>(list);
        Map<String, Object> result = new HashMap<>();
        result.put("rows", list);
        result.put("total", pi.getTotal());
        return result;
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

    @Override
    public int unreadNum(Integer shopId) {
        return mapper2.unreadNum(shopId);
    }

    @Override
    public void buhuoNotice() {
        try {
            List<ShopItem_Descript> shopitems = mapper3.checkNum();
            Notice alarm = new Notice();
            NoticeShop noticeShop = new NoticeShop();
            if (shopitems != null && shopitems.size() > 0) {
                for (ShopItem_Descript shopitemdescrip : shopitems) {
                    //通知表添加数据
                    String title = shopitemdescrip.getShopitemname() + "库存不足警告";
                    String content = shopitemdescrip.getSupplierid()+shopitemdescrip.getBy1()+ "提供的" + shopitemdescrip.getShopitemname() + "数量为" + shopitemdescrip.getNum() + ",库存已不足1000，请及时向供应商进货";
                    alarm.setShopid(shopitemdescrip.getShopid());
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    alarm.setDate(sdf.format(date));
                    alarm.setContent(content);
                    alarm.setTitle(title);
                    mapper1.insert(alarm);
                    //通知关系表添加数据
                    noticeShop.setShopid(shopitemdescrip.getShopid());
                    noticeShop.setId(alarm.getId());
                    noticeShop.setIsread(3);
                    mapper2.insertSelective(noticeShop);
                    System.out.print("警告发送成功");
                }
            }
        }catch (Exception e){
         e.printStackTrace();
            System.out.print("警告发送失败");
        }
    }


}
