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



}
