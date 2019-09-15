package com.sm.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.sm.dao.UserDao;
import com.sm.mapper.UserMapper;
import com.sm.po.User;

public class UserServiceTest {
	// 先获取Spring配置文件对象
	private ApplicationContext applicationContext;
	
	// 使用注解@Before,在执行本类中所有测试方法之前,会先执行这个方法
	public void setup() throws Exception {
		applicationContext = new 
		ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	}
	
	@Test
	public void FindUserByIdTest() throws Exception {
		setup();
		// 通过配置资源对象获取userDao对象
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		// 调用查询方法
		User user = userDao.findUserById(4);
		
		//动态代理方法
//		UserMapper userMapper = (UserMapper) applicationContext.getBean("userDao");
//		User user = userMapper.findUserById(4);
		
		StringBuffer result = new StringBuffer();
		result.append("用户名: " + user.getUsername() + "\r\n");
		result.append("性别: " + user.getGender() + "\r\n");
		result.append("电子邮箱: " + user.getEmail() + "\r\n");
		result.append("省份: " + user.getProvince() + "\r\n");
		result.append("城市: " + user.getCity() + "\r\n");
		
		System.out.println(result.toString());
	}
	public static void main(String[] args) throws Exception {
		UserServiceTest userTest = new UserServiceTest();
		userTest.FindUserByIdTest();

	}

}
