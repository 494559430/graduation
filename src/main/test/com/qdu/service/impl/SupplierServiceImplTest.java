package com.qdu.service.impl;

import com.qdu.bean.Supplier;
import com.qdu.service.SupplierService;
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
public class SupplierServiceImplTest {
    @Autowired
    SupplierService service = new SupplierServiceImpl();
    @Test
    public void doAdd() throws Exception {
        System.out.println("供应商添加成功");
    }

    @Test
    public void getSupplier() throws Exception {
        service.getSupplier(1);
    }

    @Test
    public void query() throws Exception {
        service.query(1,20,new Supplier());
    }

    @Test
    public void update() throws Exception {
        Supplier supplier = new Supplier();
        supplier.setSuppliername("大润发");
        supplier.setSupplierid(1);
        service.update(supplier);
    }

    @Test
    public void getList() throws Exception {
        service.getList();
    }

}