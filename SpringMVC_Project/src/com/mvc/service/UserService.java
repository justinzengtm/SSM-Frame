package com.mvc.service;

import java.util.List;
import com.mvc.model.User;

public interface UserService {
	public List<User> queryUserList(); // 查询所有顾客信息
	public List<User> queryUserById(Integer id); // id查找
	public List<User> queryUserByCondition(User user); // 条件查找
}
