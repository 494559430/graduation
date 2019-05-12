package com.qdu.service.impl;

import com.qdu.bean.Emp;
import com.qdu.bean.Job;
import com.qdu.service.EmpService;
import com.qdu.utils.ComboNode;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2019/5/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext-mybatis.xml"})
public class EmpServiceImplTest {
    @Autowired
    EmpService service = new EmpServiceImpl();

    @Test
    public void doAdd() throws Exception {
        Emp emp = new Emp();

        emp.setShopid(1);
        emp.setEmpname("test");
        assertEquals(1, service.doAdd(emp));
    }

    @Test
    public void getEmp() throws Exception {

        assertEquals(1, service.getEmp(1).getEmpid().intValue());
        System.out.print(service.getEmp(1).getEmpname());
    }

    @Test
    public void getJob() throws Exception {
        List<ComboNode> list = service.getJob(1);
        for (ComboNode comboNode: list
                ) {
            System.out.println(comboNode.getText());
        }
    }

    @Test
    public void query() throws Exception {
        service.query(1,10,new Emp());
    }

    @Test
    public void update() throws Exception {
        System.out.println("jiasfhaosf");
    }

    @Test
    public void addJob() throws Exception {
        System.out.println("jiasfhaosf");
    }



    @Test
    public void fire() throws Exception {
        System.out.println("炒鱿鱼");
    }

}