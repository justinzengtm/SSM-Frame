package com.mybatis.test;

import java.io.IOException;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.mybatis.datasource.DataConnection;
import com.mybatis.po.ShoppingCart;
import com.mybatis.po.ShoppingCartInstance;

public class MyBatisTestShoppingCart {
	public DataConnection dataConn = new DataConnection();
	
	// ShoppingCart简单查询
	public void TestShoppingCartSelect() throws IOException {
		SqlSession sqlSession = dataConn.getSqlSession();
		// 查找用户id为"2"的购物信息
		List<ShoppingCart> resultList = sqlSession.selectList("queryShoppingCart", 2); 
		StringBuffer result = new StringBuffer();
		double totalAmount;
		
		System.out.println("用户id： " + 2 + " 商品列表：");
		for(int i=0; i<resultList.size(); i++) {
			ShoppingCart shoppingCart = resultList.get(i);
			result.append("商品名：" + shoppingCart.getProductName() + "\r\n");
			result.append("商品价格：" + shoppingCart.getPrice() + "\r\n");
			result.append("商品数量：" + shoppingCart.getNumber() + "\r\n");
			totalAmount = (shoppingCart.getPrice()*shoppingCart.getNumber());
			result.append("商品总价：" + String.format("%.2f", totalAmount) + "\r\n");
			
			System.out.println(result.toString());
			result.setLength(0);
		}
		
		sqlSession.close();
	}
	
	// 关联的嵌套结果
	public void TestAssociationQuery() throws IOException {
		SqlSession sqlSession = dataConn.getSqlSession();
		List<ShoppingCartInstance> resultList = sqlSession.selectList("queryShoppingCartInstance", 2);
		StringBuffer result = new StringBuffer();
		double totalAmount;
		
		System.out.println("顾客姓名： " + resultList.get(1).getUser().getUsername());
		System.out.println("性别： " + resultList.get(1).getUser().getGender());
		System.out.println("商品清单：" + "\r\n");
		
		for(int i=0; i<resultList.size(); i++) {
			ShoppingCartInstance shoppingCartInstance = resultList.get(i);
			result.append("商品名：" + shoppingCartInstance.getProductName() + "\r\n");
			result.append("商品价格：" + shoppingCartInstance.getPrice() + "\r\n");
			result.append("商品数量：" + shoppingCartInstance.getNumber() + "\r\n");
			totalAmount = (shoppingCartInstance.getPrice()*shoppingCartInstance.getNumber());
			result.append("商品总价：" + String.format("%.2f", totalAmount) + "\r\n");
			
			System.out.println(result.toString());
			result.setLength(0);
		}
		
		sqlSession.close();
	}
	
	public static void main(String[] args) throws IOException {
		MyBatisTestShoppingCart testShoppingCart = new MyBatisTestShoppingCart();
//		testShoppingCart.TestShoppingCartSelect();
		testShoppingCart.TestAssociationQuery();
	}

}
