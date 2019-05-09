package com.qdu.controller;

import com.qdu.bean.Shop;
import com.qdu.service.ShopItemService;
import com.qdu.service.ShopService;
import com.qdu.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by 85181 on 2019/5/8.
 */
@Controller
@RequestMapping(value = "/shop")
public class ShopController {

    @Autowired
    ShopService shopService;

    @Autowired
    ShopItemService shopItemService;

    @RequestMapping(value = "getList")
    @ResponseBody
    public Map<String,Object> getList(Integer page, Integer rows,Shop shop){
        Map<String,Object> map = shopService.getList(page,rows,shop);
        return map;
    }

    @RequestMapping(value = "add")
    @ResponseBody
    public ResultMsg addshop(Shop shop){
        int i = shopService.addShop(shop);
        ResultMsg msg = new ResultMsg();
        if (i>=1){
            msg.setCode(200);
            msg.setMsg("添加成功");
        }else{
            msg.setCode(500);
            msg.setMsg("添加失败");
        }

        return msg;
    }

    @RequestMapping(value = "/toupdate")
    public String toupdate(int shopid,HttpServletRequest request){
        Shop shop = shopService.getShopById(shopid);
        request.setAttribute("shop",shop);
        return "shop/toshopupdate";
    }

    @RequestMapping(value = "/getDetail")
    public String getDetail(int shopid,HttpServletRequest request){
        Shop shop = shopService.getShopById(shopid);
        request.setAttribute("shop",shop);
        return "shop/toshopDetail";
    }

    @RequestMapping(value = "update")
    @ResponseBody
    public ResultMsg update(Shop shop){
        ResultMsg msg = new ResultMsg();
        int i = shopService.update(shop);
        if (i>=1){
            msg.setCode(200);
            msg.setMsg("修改成功");
        }else{
            msg.setCode(500);
            msg.setMsg("修改失败");
        }

        return msg;
    }

    @RequestMapping(value = "getshopList")
    @ResponseBody
    public List<Shop> getshopList(){
        List<Shop> list = shopService.getshopList();
        return  list;
    }
}
