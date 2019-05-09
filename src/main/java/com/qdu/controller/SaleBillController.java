package com.qdu.controller;

import com.qdu.bean.SalebillShow;
import com.qdu.bean.User;
import com.qdu.service.SaleBillService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by 85181 on 2019/5/7.
 */
@Controller
@RequestMapping("/SaleBill")
public class SaleBillController {
    @Autowired
    SaleBillService saleBillService;

    @RequestMapping("/getSaleBillByType")
    @ResponseBody
    public List<SalebillShow> getSaleBillByType(HttpServletRequest request){
        User u = (User) request.getSession().getAttribute("user");
        int id = u.getShopId();
        List<SalebillShow> list = saleBillService.getSaleBillByType(id);
        return list;

    }

    @RequestMapping("getSaleBillByDate")
    @ResponseBody
    public List<SalebillShow> getSaleBillByDate(HttpServletRequest request){
        User u = (User) request.getSession().getAttribute("user");
        int id = u.getShopId();
        Map<String,Object> map = new HashedMap();
        map.put("shopid",id);
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM");
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH,-13);
        Date begindate = c.getTime();
        map.put("begindate",sdf.format(begindate));
        map.put("enddate",sdf.format(date));
        System.out.println(sdf.format(begindate)+"-------"+sdf.format(date));
        List<SalebillShow> list = saleBillService.getSaleBillByDate(map);
        return list;
    }



}
