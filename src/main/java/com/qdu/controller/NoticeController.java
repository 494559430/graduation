package com.qdu.controller;

import com.qdu.bean.Notice;
import com.qdu.bean.Shop;
import com.qdu.bean.User;
import com.qdu.service.NoticeService;
import com.qdu.service.ShopItemService;
import com.qdu.service.ShopService;
import com.qdu.utils.ComboNode;
import com.qdu.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    @RequestMapping(value="/getList")
    @ResponseBody
    public Map<String,Object> query(Integer page, Integer rows,Notice notice,HttpSession session){
        User u = (User) session.getAttribute("user");
        notice.setShopid(u.getShopId());
        return service.getNoticeByShopid(page, rows, notice);
    }
    @RequestMapping(value="/getDetail")

    public String getDetail(int id,Model m,HttpSession session){

            Notice n =service.getNoticeById(id);
            m.addAttribute("n", n);
        User u = (User) session.getAttribute("user");
        service.updateRead(id,u.getShopId());
        return "/shop/noticeDetial";
    }

    @RequestMapping(value = "/deleteNotice")
    @ResponseBody
    public ResultMsg deleteNotice(String ids,HttpServletRequest request){
        ResultMsg msg = new ResultMsg();
        String[] id = ids.split(",");

        User u = (User) request.getSession().getAttribute("user");
        int i = service.delete(id,u.getShopId());
        if(i>=1){
            msg.setCode(200);
            msg.setMsg("删除成功");
        }else{
            msg.setCode(500);
            msg.setMsg("删除失败");
        }
        return msg;
    }
}
