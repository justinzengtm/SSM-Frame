package com.sm.dao;

import java.util.List;
import com.sm.po.User;

// 用户管理Dao接口
public interface UserDao {
	public User findUserById(int id) throws Exception;
	public List<User> multiSearch() throws Exception;
}
