package com.qdu.controller;

import java.util.HashMap;
import java.util.Map;

import com.qdu.service.NoticeService;
import com.qdu.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qdu.bean.User;
import com.qdu.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	public UserService service;
	@Autowired
	public NoticeService noticeService;
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add(User user){
		Map<String,Object> result= new HashMap<>();
		try {
			service.add(user);
			result.put("flag", "success");
			result.put("msg", user.getUsername()+"成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("flag", "error");
			result.put("msg", e.getMessage());
		}
		return result;
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public ResultMsg login(User u, HttpServletRequest request){
		User user = service.login(u);

		if (user!=null&&user.getUsername()!=null){
			request.getSession().setAttribute("user",user);
			int num = noticeService.unreadNum(user.getShopId());
			request.getSession().setAttribute("unread",num);
			return new ResultMsg(1,"登陆成功，请等待跳转。。。。");
		}

		return new ResultMsg(0,"登录失败，帐号密码错误！");
	}
	@RequestMapping(value="/logout")

	public String logout(HttpSession session){
		session.invalidate();
		return "login";
	}
}
