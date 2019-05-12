package com.qdu.service.impl;

import com.qdu.bean.ShopItem_Descript;
import com.qdu.service.EmpService;
import com.qdu.service.ShopItemService;
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
public class ShopItemServiceImplTest {
    @Autowired
    ShopItemService service = new ShopItemServiceImpl();
    @Test
    public void getList() throws Exception {
        service.getList(1,10,new ShopItem_Descript());
    }

    @Test
    public void getItemDetail() throws Exception {
        service.getItemDetail();
    }

    @Test
    public void getDetail() throws Exception {
        service.getDetail(1);
    }

    @Test
    public void getDetail2() throws Exception {
        service.getDetail2(1,1);
    }

}