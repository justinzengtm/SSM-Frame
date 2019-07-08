package com.mybatis.test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import com.mybatis.datasource.DataConnection;
import com.mybatis.po.User;

public class MyBatisTest {
	public DataConnection dataConn = new DataConnection();
	
	public void TestSelect() throws IOException {
		SqlSession sqlSession = dataConn.getSqlSession();
		User user = sqlSession.selectOne("SQLtest.findUserById", 1);
		StringBuffer result = new StringBuffer();
		result.append("用户名: " + user.getUsername() + "\r\n");
		result.append("密码: " + user.getPassword() + "\r\n");
		result.append("性别: " + user.getGender() + "\r\n");
		result.append("电子邮箱: " + user.getEmail() + "\r\n");
		result.append("省份: " + user.getProvince() + "\r\n");
		result.append("城市: " + user.getCity() + "\r\n");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		result.append("出生日期: " + sdf.format(user.getbirthday()) + "\r\n");
		
		System.out.println(result.toString());
		sqlSession.close();
	}
	
	public void TestDelete() throws IOException {
		SqlSession sqlSession = dataConn.getSqlSession();
		sqlSession.delete("SQLtest.deleteUser", "测试用户");
		sqlSession.commit();
		sqlSession.close();
	}
	
	public void TestUpdate() throws IOException {
		SqlSession sqlSession = dataConn.getSqlSession();
		User user = new User();
		user.setId(7);
		user.setGender("女");
		
		sqlSession.update("SQLtest.updateUser", user);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public void TestInsert() throws IOException, ParseException {
		SqlSession sqlSession = dataConn.getSqlSession();
		User user = new User();
		user.setUsername("杨丽");
		user.setPassword("666");
		user.setGender("女");
		user.setEmail("666@126.com");
		user.setProvince("广东省");
		user.setCity("广州市");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		user.setbirthday(sdf.parse("1999-03-18"));
		
		sqlSession.insert("SQLtest.insertUser", user);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public void TestMultiSelect() throws IOException {
		SqlSession sqlSession = dataConn.getSqlSession();
		List<User> resultList = sqlSession.selectList("SQLtest.multiSearch");
		StringBuffer result = new StringBuffer();
		
		for(int i=0; i<resultList.size(); i++) {
			User user = resultList.get(i);
			result.append("用户名: " + user.getUsername() + "\r\n");
			result.append("密码: " + user.getPassword() + "\r\n");
			result.append("性别: " + user.getGender() + "\r\n");
			result.append("电子邮箱: " + user.getEmail() + "\r\n");
			result.append("省份: " + user.getProvince() + "\r\n");
			result.append("城市: " + user.getCity() + "\r\n");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			result.append("出生日期: " + sdf.format(user.getbirthday()) + "\r\n");
			
			System.out.println(result.toString());
			result.setLength(0);
		}
		
		sqlSession.close();
	}
	
	public static void main(String[] args) throws IOException, ParseException {
		MyBatisTest testBatis = new MyBatisTest();
//		testBatis.TestMultiSelect();
		testBatis.TestSelect();
//		testBatis.TestDelete();
//		testBatis.TestUpdate();
//		testBatis.TestInsert();
	}
}
