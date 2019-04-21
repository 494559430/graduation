package com.qdu.mapper;

import org.springframework.stereotype.Repository;

import com.qdu.bean.User;
@Repository
public interface UserMapper {
	int add(User user);
	User select(User user);

}
