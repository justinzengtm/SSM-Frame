package com.sm.mapper;

import com.sm.po.User;

public interface UserMapper {
	public User findUserById(int id) throws Exception;
}
