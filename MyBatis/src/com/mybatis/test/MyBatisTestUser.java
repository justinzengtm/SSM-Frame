package com.mybatis.test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.mybatis.datasource.DataConnection;
import com.mybatis.po.User;

public class MyBatisTestUser {
	public DataConnection dataConn = new DataConnection();
	
	@Test
	// 查询单个用户
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
		result.append("出生日期: " + sdf.format(user.getBirthday()) + "\r\n");
		result.append("年龄：" + user.getAge() + "\r\n");
		
		System.out.println(result.toString());

		sqlSession.close();
	}
	
	// 用户表删除
	public void TestDelete() throws IOException {
		SqlSession sqlSession = dataConn.getSqlSession();
		sqlSession.delete("SQLtest.deleteUser", "测试用户");
		sqlSession.commit();
		sqlSession.close();
	}
	
	// 用户表更新
	public void TestUpdate() throws IOException {
		SqlSession sqlSession = dataConn.getSqlSession();
		User user = new User();
		user.setId(7);
		user.setGender("男");
		
		sqlSession.update("SQLtest.updateUser", user);
		sqlSession.commit();
		sqlSession.close();
	}
	
	// 用户表插入
	public void TestInsert() throws IOException, ParseException {
		SqlSession sqlSession = dataConn.getSqlSession();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String userBirthday = "1999-03-18";
		Date uBirthday = sdf.parse(userBirthday);
		User user = new User("杨丽","666","女","666@126.com","广东省","广州市",uBirthday);
//		user.setBirthday(sdf.parse(userBirthday));
		
		// 计算年龄
		Date Now = new Date();
		long age = (((Now.getTime() - uBirthday.getTime()) / (24*60*60*1000)) / 365);
		user.setAge((int)age);

		sqlSession.insert("SQLtest.insertUser", user);
		sqlSession.commit();
		sqlSession.close();
	}
	
	// 用户表多个查询
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
			result.append("出生日期: " + sdf.format(user.getBirthday()) + "\r\n");
			result.append("年龄: " + user.getAge() + "\r\n");
			
			System.out.println(result.toString());
			result.setLength(0);
		}
		
		sqlSession.close();
	}
	
	public static void main(String[] args) throws IOException, ParseException {
		MyBatisTestUser testBatis = new MyBatisTestUser();
		testBatis.TestMultiSelect();
//		testBatis.TestSelect();
//		testBatis.TestDelete();
//		testBatis.TestUpdate();
//		testBatis.TestInsert();
	}
}
