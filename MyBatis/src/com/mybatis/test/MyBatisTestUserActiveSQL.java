package com.mybatis.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.mybatis.datasource.DataConnection;
import com.mybatis.po.User;

public class MyBatisTestUserActiveSQL {
	public DataConnection dataConn = new DataConnection();
	
	@Test
	// if表达式
	public void TestActiveIf() throws IOException {
		SqlSession sqlSession = dataConn.getSqlSession();
		StringBuffer result = new StringBuffer();
		User newUser = new User();
//		newUser.setUsername("张三");
//		newUser.setCity("广州市");
		List<User> resultList = sqlSession.selectList("UserActiveSearch_if", newUser);
		
		for(int i=0; i<resultList.size(); i++) {
			User user = resultList.get(i);
			result.append("用户名: " + user.getUsername() + "\r\n");
			result.append("性别: " + user.getGender() + "\r\n");
			result.append("电子邮箱: " + user.getEmail() + "\r\n");
			result.append("城市: " + user.getCity() + "\r\n");
			
			System.out.println(result.toString());
			result.setLength(0);
		}

		sqlSession.close();
	}
	
	@Test
	// choose表达式
	public void TestActiveChoose() throws IOException {
		SqlSession sqlSession = dataConn.getSqlSession();
		StringBuffer result = new StringBuffer();
		User instance = new User();
//		instance.setUsername("王五");
//		instance.setEmail("666@126.com");
		List<User> resultList = sqlSession.selectList("UserActiveSearch_choose", instance);

		for(int i=0; i<resultList.size(); i++) {
			User user = resultList.get(i);
			result.append("用户名: " + user.getUsername() + "\r\n");
			result.append("性别: " + user.getGender() + "\r\n");
			result.append("电子邮箱: " + user.getEmail() + "\r\n");
			result.append("城市: " + user.getCity() + "\r\n");
			
			System.out.println(result.toString());
			result.setLength(0);
		}

		sqlSession.close();
	}
	
	@Test
	// foreach表达式
	public void TestActiveForeach() throws IOException {
		SqlSession sqlSession = dataConn.getSqlSession();
		StringBuffer result = new StringBuffer();
		
		List<Integer> idNum = new ArrayList<Integer>();
		for(int j=1; j<6; j+=2) {
			idNum.add(j);
		}
		
		List<User> resultList = sqlSession.selectList("UserActive_foreach1", idNum);
		
		for(int i=0; i<resultList.size(); i++) {
			User user = resultList.get(i);
			result.append("用户id: " + user.getId() + "\r\n");
			result.append("用户名: " + user.getUsername() + "\r\n");
			result.append("性别: " + user.getGender() + "\r\n");
			result.append("电子邮箱: " + user.getEmail() + "\r\n");
			result.append("城市: " + user.getCity() + "\r\n");
			
			System.out.println(result.toString());
			result.setLength(0);
		}

		sqlSession.close();
	}
	public static void main(String[] args) throws IOException {
		MyBatisTestUserActiveSQL testActiveSQL = new MyBatisTestUserActiveSQL();
//		testActiveSQL.TestActiveIf();
//		testActiveSQL.TestActiveChoose();
		testActiveSQL.TestActiveForeach();
	}

}
