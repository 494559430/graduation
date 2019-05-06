package com.qdu.controller;

import com.qdu.bean.Shopitem;
import com.qdu.bean.Shopitemtype;
import com.qdu.service.ShopItemTyppeService;
import com.qdu.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 85181 on 2019/4/6.
 */

@Controller
@RequestMapping(value = "/ShopItemTypeController")
public class ShopItemTypeController {
    @Autowired
    ShopItemTyppeService shopItemTyppeService;

    @ResponseBody
    @RequestMapping(value = "/getItemType")
    public List<Shopitemtype> getItemType(){
        List<Shopitemtype> list =null;
        list = shopItemTyppeService.getList();

        return list;
    }

    @ResponseBody
    @RequestMapping(value = "/getshopitemtype")
    public List<Shopitemtype> getShopitemtypeSon(){
        List<Shopitemtype> list =shopItemTyppeService.getList();
        List<Shopitemtype> list2 =new ArrayList<>();
        for (Shopitemtype shopitemtype:list) {
            if (shopitemtype.getParentid()!=shopitemtype.getTypeid()){
                list2.add(shopitemtype);
            }
        }
        return list2;
    }


    @RequestMapping(value = "/toaddParent")
    public String toaddParent(){
        return "shopitem/toaddParent";
    }


    @RequestMapping(value = "/toaddSon")
    public String toaddSon(){
        return "shopitem/toaddSon";
    }

    @ResponseBody
    @RequestMapping(value = "/getshopitemtypeParent")
    public List<Shopitemtype> getShopitemtypeParent(){
        List<Shopitemtype> list =shopItemTyppeService.getList();
        List<Shopitemtype> list2 =new ArrayList<>();
        for (Shopitemtype shopitemtype:list) {
            if (shopitemtype.getParentid()==shopitemtype.getTypeid()){
                list2.add(shopitemtype);
            }
        }
        return list2;
    }

    @ResponseBody
    @RequestMapping(value = "/addParent")
    public ResultMsg addParent(Shopitemtype shopitemtype){
        ResultMsg msg = new ResultMsg();
        int i = shopItemTyppeService.insertParent(shopitemtype);
        shopitemtype.setParentid(shopitemtype.getTypeid());
        shopItemTyppeService.update(shopitemtype);
        if (i>=1){
            msg.setCode(200);
            msg.setMsg("添加成功");
        }else {
            msg.setCode(500);
            msg.setMsg("添加失败");
        }
        return msg;
    }

    @ResponseBody
    @RequestMapping(value = "/addSon")
    public ResultMsg addSon(Shopitemtype shopitemtype){
        ResultMsg msg = new ResultMsg();
        int i = shopItemTyppeService.insertSon(shopitemtype);
        if (i>=1){
            msg.setCode(200);
            msg.setMsg("添加成功");
        }else {
            msg.setCode(500);
            msg.setMsg("添加失败");
        }
        return msg;
    }
}
