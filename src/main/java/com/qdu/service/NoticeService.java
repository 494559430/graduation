package com.qdu.service;

import com.qdu.bean.Notice;

import java.util.List;
import java.util.Map;

/**
 * Created by chenzb on 2019/5/13.
 */
public interface NoticeService {
    boolean addNotice(Notice notice);
    Map<String, Object> getAllNotice();
    Map<String, Object> getNoticeByShopid(Integer page, Integer rows, Notice notice);

    Notice getNoticeById(int id);

    void updateRead(int id, Integer shopId);

    int delete(String[] id,Integer shopid);

    int unreadNum(Integer shopId);
}
