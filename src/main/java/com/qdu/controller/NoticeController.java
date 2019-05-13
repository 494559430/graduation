package com.qdu.controller;

import com.qdu.bean.Notice;
import com.qdu.bean.Shop;
import com.qdu.service.NoticeService;
import com.qdu.service.ShopItemService;
import com.qdu.service.ShopService;
import com.qdu.utils.ComboNode;
import com.qdu.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 85181 on 2019/5/8.
 */
@Controller
@RequestMapping(value = "/notice")
public class NoticeController {

    @Autowired
    NoticeService service;

    @RequestMapping(value = "/addNotice")
    @ResponseBody
    public ResultMsg addNotice(Notice notice){

        if (service.addNotice(notice)){
            return new ResultMsg(1,"发布成功");
        }
        return new ResultMsg(0,"发布失败，请联系管理员!!");
    }

}
