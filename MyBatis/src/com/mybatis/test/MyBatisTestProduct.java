package com.mybatis.test;

import java.io.IOException;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.mybatis.datasource.DataConnection;
import com.mybatis.po.Product;

// 商品表查询测试类
public class MyBatisTestProduct {
	public DataConnection dataConn = new DataConnection();
	
	public void queryProductTest() throws IOException {
		SqlSession sqlSession = dataConn.getSqlSession();
		List<Product> resultList = sqlSession.selectList("queryProductInfo");
		StringBuffer result = new StringBuffer();
		
		for(int i=0; i<resultList.size(); i++) {
			Product product = resultList.get(i);
			result.append("商品id：" + product.getProductId() + "\r\n");
			result.append("商品名：" + product.getProductName() + "\r\n");
			result.append("商品价格：" + product.getProductPrice() + "\r\n");
			
			System.out.println(result.toString());
			result.setLength(0);
		}
		
		sqlSession.close();
	}
	public static void main(String[] args) throws IOException {
		MyBatisTestProduct testProduct = new MyBatisTestProduct();
		testProduct.queryProductTest();

	}

}
