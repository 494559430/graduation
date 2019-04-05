package com.qdu.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/emp")
public class EmpController {



    @RequestMapping(value = "/dept")
    public String dept(){
        return "/emp/dept";
    }

    @RequestMapping(value = "/emp")
    public String emp(){

        System.out.println("54saf654saf");
        return "/emp/emp";
    }



}
