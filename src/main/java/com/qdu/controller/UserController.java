package com.qdu.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qdu.bean.User;
import com.qdu.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	public UserService service;
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add(User user){
		Map<String,Object> result= new HashMap<>();
		try {
			service.add(user);
			result.put("flag", "success");
			result.put("msg", user.getUsername()+"成功");
		} catch (RuntimeException re) {
			result.put("flag", "error");
			result.put("msg", re.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			result.put("flag", "error");
			result.put("msg", e.getMessage());
		}
		return result;
	}
}
