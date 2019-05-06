package com.qdu.controller;

import com.qdu.bean.ShopItem_Descript;
import com.qdu.bean.Shopitem;
import com.qdu.bean.Shopitemdescrip;
import com.qdu.bean.User;
import com.qdu.service.ShopItemService;
import com.qdu.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by 85181 on 2019/5/2.
 */
@Controller
@RequestMapping(value = "/shopItem")
public class ShopItemController {
    @Autowired
    ShopItemService shopItemService;

    /**
     * 得到商品列表
     * @param page
     * @param rows
     * @param shopItem_descript
     * @param request
     * @return
     */
    @RequestMapping(value = "/getList")
    @ResponseBody
    public Map<String ,Object> GetList(Integer page, Integer rows,ShopItem_Descript shopItem_descript,HttpServletRequest request){
    User user = (User) request.getSession().getAttribute("user");
    shopItem_descript.setShopid(user.getShopId());
    Map<String ,Object> map = shopItemService.getList(page,rows,shopItem_descript);
    return map;
    }

    /**
     * 得到商品详情
     * @param shopitemid
     * @return
     */
    @RequestMapping(value = "/getDetail")
    public String getDetail(Integer shopitemid, HttpServletRequest request){
        Shopitemdescrip shopitemdescrip = shopItemService.getDetail(shopitemid);
        request.setAttribute("shopitemdescrip",shopitemdescrip);
        return "shopitem/itemDetail";
    }

    @RequestMapping(value = "/update")
    public String update(Integer shopitemid, HttpServletRequest request) {
        Shopitemdescrip shopitemdescrip = shopItemService.getDetail(shopitemid);
        request.setAttribute("shopitemdescrip", shopitemdescrip);
        return "shopitem/itemUpdate";
    }

    @RequestMapping(value = "/update2")
    @ResponseBody
    public ResultMsg update2(Shopitemdescrip shopitemdescrip, HttpServletRequest request) {
        ResultMsg msg = new ResultMsg();
        int i = shopItemService.update(shopitemdescrip);
        if(i>=1){
            msg.setCode(200);
            msg.setMsg("修改商品成功");
        }else{
            msg.setCode(500);
            msg.setMsg("修改失败");
        }
        return msg;
    }

    @RequestMapping(value="/add")
    @ResponseBody
    public ResultMsg add(Shopitemdescrip shopitemdescrip,String ifgrounding, HttpServletRequest request) {
        ResultMsg msg = new ResultMsg();

        int i = shopItemService.add(shopitemdescrip);


        //得到所有 shopid 添加到  shopitem 表

        if(i>=1){
            msg.setCode(200);
            msg.setMsg("添加商品成功");
        }else{
            msg.setCode(500);
            msg.setMsg("添加失败");
        }
        return msg;
    }


}
