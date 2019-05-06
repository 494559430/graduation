package com.qdu.controller;



import com.qdu.bean.Supplier;
import com.qdu.service.SupplierService;

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
@RequestMapping(value = "/supplier")
public class SupplierController {
    @Resource
    private SupplierService service;



    @RequestMapping(value = "/addSupplier")
    @ResponseBody
    public ResultMsg addSupplier(Supplier s){

        if(service.doAdd(s)>0)
        return new ResultMsg(200,"添加供应商成功");
        return new ResultMsg(500,"添加供应商失败");
    }
    @RequestMapping(value = "/supplier")
    public String emp(){
        return "/supplier/supplier";
    }

    @RequestMapping(value = "/addAndUpdate")
    public String addAndUpdate(Integer id,Model m){
        if (id!=null) {
            Supplier s =service.getSupplier(id);
            m.addAttribute("s", s);
        }
        return "/supplier/addAndUpdate";
    }
    @RequestMapping(value = "/update")
    @ResponseBody
    public ResultMsg update(Supplier s){
        if(service.update(s)>0)
        return new ResultMsg(200,"更新供应商信息成功!!");
        return new ResultMsg(500,"更新供应商信息失败!!");
    }

    @RequestMapping(value="/list",method= RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> query(Integer page, Integer rows, Supplier supplier){

        return service.query(page, rows, supplier);
    }


    @RequestMapping(value = "getsupplier")
    @ResponseBody
    public List<Supplier> getSupplier(){
        return  service.getList();
    }
}
