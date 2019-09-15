package com.sm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import com.sm.po.User;

// 查询用户信息UserDap接口的实现类
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {
	// 查询单个指定id用户
	@Override
	public User findUserById(int id) throws Exception {
		// 继承SqlSessionDaoSupport类, 通过this.getSqlSession()得到sqlSession
		SqlSession sqlSession = this.getSqlSession();
		User user = sqlSession.selectOne("findUserById", id);
		
		return user;
	}

	@Override
	public List<User> multiSearch() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
