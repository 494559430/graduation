package com.qdu.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/turn")
public class TurnController {



    @RequestMapping(value = "/tolist")
    public String tolist(){
        return "/pages/list";
    }

    @RequestMapping(value = "/tolist2")
    public String tolist2(){
        return "/pages/list2";
    }


    @RequestMapping(value = "/toshopItemType")
    public String toshopItemType(){
        return "shopitem/shopItemType";
    }

    @RequestMapping(value = "/toshopItem")
    public String toshopItem(){
        return "shopitem/shopItem";
    }

    @RequestMapping(value = "/toshopItemAdd")
    public String toshopItemAdd(){
        return "shopitem/toshopItemAdd";
    }

    @RequestMapping(value = "/tosalebill")
    public String tosaleBill(){
        return "shopitem/tosalebill";
    }

    @RequestMapping(value = "/toshop")
    public String toShop(){
        return "shop/toshop";
    }
    @RequestMapping(value = "/toNotice")
    public String toNotice(){
        return "shop/tonotice";
    }

    @RequestMapping(value = "/toshopAdd")
    public String toshopAdd(){
        return "shop/toshopAdd";
    }


}
