package com.qdu.service;

import com.qdu.bean.Notice;

import java.util.List;

/**
 * Created by chenzb on 2019/5/13.
 */
public interface NoticeService {
    boolean addNotice(Notice notice);
    List<Notice> getAllNotice();
    List<Notice> getNoticeByShopid1(int shopid);
    List<Notice> getNoticeByShopid2(int shopid);
}
