package com.qdu.service.impl;

import javax.annotation.Resource;



import com.qdu.bean.User;
import com.qdu.mapper.UserMapper;
import com.qdu.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	@Resource
	private UserMapper mapper;
	
	@Override
	public int add(User user) {
		int i =mapper.add(user);
		if (i<=0) {
			throw new RuntimeException("添加用户"+user.getUsername()+"失败");
		} else {
			return i;
		}
	}

}
