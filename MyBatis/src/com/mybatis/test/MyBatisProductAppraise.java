package com.mybatis.test;

import java.io.IOException;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.mybatis.datasource.DataConnection;
import com.mybatis.po.ProductAppraise;
import com.mybatis.po.ProductInstance;

// 测试商品评价表
public class MyBatisProductAppraise {
	public DataConnection dataConn = new DataConnection();
	
	public void queryProductAppraiseTest() throws IOException {
		SqlSession sqlSession = dataConn.getSqlSession();
		List<ProductAppraise> resultList = sqlSession.selectList("queryProductAppraiseInfo", 230270);
		StringBuffer result = new StringBuffer();
		
		System.out.println("商品id：230270 的顾客评价信息：");
		for(int i=0; i<resultList.size(); i++) {
			ProductAppraise productAppraise = resultList.get(i);
			result.append("商品评分：" + productAppraise.getProductScore() + "\r\n");
			result.append("用户id：" + productAppraise.getUserId() + "\r\n");
			
			System.out.println(result.toString());
			result.setLength(0);
		}
		
		sqlSession.close();
	}
	
	public void queryProductInstance() throws IOException {
		SqlSession sqlSession = dataConn.getSqlSession();
		List<ProductInstance> resultList = sqlSession.selectList("queryProductInstance", 230270);
		StringBuffer result = new StringBuffer();
		
		System.out.println("商品名：" + resultList.get(1).getProductName());
		System.out.println("商品价格：" + resultList.get(1).getProductPrice() + "\r\n");
		
		for(int i=0; i<resultList.size(); i++) {
			List<ProductAppraise> appraiseList = resultList.get(i).getProductAppraiseList();
			ProductAppraise productAppraise = appraiseList.get(0);
			result.append("商品评分：" + productAppraise.getProductScore() + "\r\n");
			result.append("评价用户id：" + productAppraise.getUserId() + "\r\n");
			
			System.out.println(result.toString());
			result.setLength(0);
		}
		
		sqlSession.close();
	}
	
	public static void main(String[] args) throws IOException {
		MyBatisProductAppraise testProductAppraise = new MyBatisProductAppraise();
//		testProductAppraise.queryProductAppraiseTest();
		testProductAppraise.queryProductInstance();
	}

}
