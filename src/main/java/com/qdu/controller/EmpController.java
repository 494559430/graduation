package com.qdu.controller;



import com.qdu.bean.Emp;
import com.qdu.bean.Job;
import com.qdu.service.EmpService;
import com.qdu.utils.ComboNode;
import com.qdu.utils.ResultMsg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
        if(service.addJob(job)>0)
            return new ResultMsg(200,"添加职位成功");
        return new ResultMsg(500,"添加职位失败");
    }
    @RequestMapping(value = "/addEmp")
    @ResponseBody
    public ResultMsg addEmp(Emp e){

        if(service.doAdd(e)>0)
        return new ResultMsg(200,"添加员工成功");
        return new ResultMsg(500,"添加员工失败");
    }
    @RequestMapping(value = "/del")
    @ResponseBody
    public ResultMsg del(Integer empid){

        if(service.fire(empid)==1)
            return new ResultMsg(200,"解雇员工成功");
        return new ResultMsg(500,"解雇员工失败");
    }
    @RequestMapping(value = "/getJob")
    @ResponseBody
    public List<ComboNode> getJob(Integer shopid){

        return service.getJob(1);
    }

    @RequestMapping(value = "/addAndUpdate")
    public String addAndUpdate(Integer id,Model m){
        if (id!=null) {
            Emp e =service.getEmp(id);
            m.addAttribute("e", e);
        }
        return "/emp/addAndUpdate";
    }
    @RequestMapping(value = "/update")
    @ResponseBody
    public ResultMsg update(Emp e){
        if(service.update(e)>0)
        return new ResultMsg(200,"更新员工信息成功!!");
        return new ResultMsg(500,"更新员工信息失败!!");
    }
    @RequestMapping(value = "/emp")
    public String emp(){
        return "/emp/emp";
    }
    @RequestMapping(value="/list",method= RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> query(Integer page, Integer rows, Emp emp){

        return service.query(page, rows, emp);
    }

}
