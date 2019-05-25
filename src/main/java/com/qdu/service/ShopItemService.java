package com.qdu.service;

import com.qdu.bean.ShopItem_Descript;
import com.qdu.bean.Shopitem;
import com.qdu.bean.Shopitemdescrip;
import com.qdu.utils.ResultMsg;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Created by 85181 on 2019/4/21.
 */
public interface ShopItemService
{
    //展示商品列表
    public Map<String,Object> getList(Integer page, Integer rows, ShopItem_Descript shopitem_descrip);

    //得到商品详细信息
    public Shopitemdescrip getItemDetail();


    Shopitemdescrip getDetail(Integer shopitemid);

    int update(Shopitemdescrip shopitemdescrip);

    int add(Shopitemdescrip shopitemdescrip);

    int add(Shopitem shopitem);

    ResultMsg add(int shopId, MultipartFile file);

    ShopItem_Descript getDetail2(Integer shopitemid,Integer shopid);

    void updateShopItem(Shopitem shopitem);
}
