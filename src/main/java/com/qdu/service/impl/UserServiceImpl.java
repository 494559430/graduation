package com.qdu.service.impl;

import javax.annotation.Resource;



import com.qdu.bean.User;
import com.qdu.mapper.NoticeShopMapper;
import com.qdu.mapper.UserMapper;
import com.qdu.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	@Resource
	private UserMapper mapper;
	@Resource
	private NoticeShopMapper mapper1;
	
	@Override
	public int add(User user) {
		int b=132;
		int i =mapper.add(user);
		if (i<=0) {
			throw new RuntimeException("添加用户"+user.getUsername()+"失败");
		} else {
			return i;
		}
	}

	@Override
	public User login(User user) {return mapper.select(user);}

}
