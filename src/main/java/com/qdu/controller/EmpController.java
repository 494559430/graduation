package com.qdu.controller;



import com.qdu.bean.Job;
import com.qdu.service.EmpService;
import com.qdu.utils.ResultMsg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/emp")
public class EmpController {
    @Resource
    private EmpService service;

    @RequestMapping(value = "/toAddJob")
    public String toAddJob(){
        return "/emp/toAddJob";
    }
    @RequestMapping(value = "/addJob")
    @ResponseBody
    public ResultMsg addJob(Job job){
        job.setShopid(1);
        service.addJob(job);
        return new ResultMsg(200,"添加职位成功");
    }

    @RequestMapping(value = "/dept")
    public String dept(){
        return "/emp/dept";
    }

    @RequestMapping(value = "/emp")
    public String emp(){
        return "/emp/emp";
    }



}
