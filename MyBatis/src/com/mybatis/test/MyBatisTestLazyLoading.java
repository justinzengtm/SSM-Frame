package com.mybatis.test;

import java.io.IOException;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.mybatis.datasource.DataConnection;
import com.mybatis.po.ShoppingCartUserLazyLoading;
import com.mybatis.po.ShoppingCartUserLazyLoadingTest;
import com.mybatis.po.User;

public class MyBatisTestLazyLoading {
	public DataConnection dataConn = new DataConnection();
	
	@Test
	public void testLazyLoading() throws Exception {
		SqlSession sqlSession = dataConn.getSqlSession();
		StringBuffer result = new StringBuffer();
		ShoppingCartUserLazyLoading SU = null; // 主对象
		User user = null; // 关联对象
		
		// 获取Mapper代理
		ShoppingCartUserLazyLoadingTest  lazyLoadingTest 
		= sqlSession.getMapper(ShoppingCartUserLazyLoadingTest.class);
		// 深度延迟加载示例
		List<ShoppingCartUserLazyLoading> 
		resultList = lazyLoadingTest.searchLazyLoading();
		
		for(int i=0; i<resultList.size(); i++) {
			// 先获得商品清单信息
			SU = resultList.get(i); // 访问主对象里的属性
			result.append("商品清单id： " + SU.getCartId() + "\r\n");

			user = SU.getUser();
			result.append("顾客名： " + user.getUsername() + "\r\n");
			result.append("城市： " + user.getCity() + "\r\n");
			result.append("电子邮件： " + user.getEmail() + "\r\n");

			System.out.println(result.toString());
			result.setLength(0);
		}
		
		sqlSession.close();
	}
	
	public static void main(String[] args) throws Exception {
		MyBatisTestLazyLoading lazyLoadingTest = new MyBatisTestLazyLoading();
		lazyLoadingTest.testLazyLoading();
	}

}
