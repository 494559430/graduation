package com.qdu.service.impl;

import com.qdu.bean.Shop;
import com.qdu.service.ShopService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2019/5/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext-mybatis.xml"})
public class ShopServiceImplTest {
    @Autowired
    ShopService service = new ShopServiceImpl();
    @Test
    public void getList() throws Exception {
        service.getList(1,20,new Shop());
    }

    @Test
    public void update() throws Exception {
       Shop shop = new Shop();
       shop.setShopname("青岛店");
       shop.setShopid(2);
       service.update(shop);
    }

    @Test
    public void getShopById() throws Exception {

        System.out.println(service.getShopById(2).getShopname());
    }

    @Test
    public void getshopList() throws Exception {
        service.getshopList();
    }

}