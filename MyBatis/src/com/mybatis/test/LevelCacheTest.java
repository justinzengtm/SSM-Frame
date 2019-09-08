package com.mybatis.test;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.mybatis.datasource.DataConnection;
import com.mybatis.po.LevelCacheMapper;
import com.mybatis.po.Product;
import com.mybatis.po.ProductAppraise;
import com.mybatis.po.ProductInstance;
import com.mybatis.po.User;

public class LevelCacheTest {
	public DataConnection dataConn = new DataConnection();
	
	// 一级缓存示例
	@Test
	public void Level1CacheInstance() throws Exception {
		SqlSession sqlSession = dataConn.getSqlSession();
		User user1 = sqlSession.selectOne("SQLtest.findUserById", 1);
		StringBuffer result = new StringBuffer();
		result.append("用户名: " + user1.getUsername() + "\r\n");
		result.append("性别: " + user1.getGender() + "\r\n");
		result.append("电子邮箱: " + user1.getEmail() + "\r\n");
		result.append("城市: " + user1.getCity() + "\r\n");
		System.out.println(result.toString());
		
		result.setLength(0);
		// 更新数据库操作
		User userUpdate = new User();
		userUpdate.setId(1);
		userUpdate.setGender("女");
		sqlSession.update("SQLtest.updateUser", userUpdate);
		sqlSession.commit();
		
		User user2 = sqlSession.selectOne("SQLtest.findUserById", 1);
		result.append("用户名: " + user2.getUsername() + "\r\n");
		result.append("性别: " + user2.getGender() + "\r\n");
		result.append("电子邮箱: " + user2.getEmail() + "\r\n");
		result.append("城市: " + user2.getCity() + "\r\n");
		System.out.println(result.toString());
		
		sqlSession.close();
	}
	
	// 二级缓存示例
	@Test
	public void Level2CacheInstance() throws Exception {
		SqlSession sqlSession = dataConn.getSqlSession();
		LevelCacheMapper levelCacheMapper = sqlSession.getMapper(LevelCacheMapper.class);
		List<ProductInstance> resultList = levelCacheMapper.queryProductInstance(230270);
		sqlSession.commit();
		StringBuffer result = new StringBuffer();
		
		System.out.println("商品名：" + resultList.get(0).getProductName());
		System.out.println("商品价格：" + resultList.get(0).getProductPrice() + "\r\n");
		
		for(int i=0; i<resultList.size(); i++) {
			List<ProductAppraise> appraiseList = resultList.get(i).getProductAppraiseList();
			ProductAppraise productAppraise = appraiseList.get(0);
			result.append("商品评分：" + productAppraise.getProductScore() + "\r\n");
			result.append("评价用户id：" + productAppraise.getUserId() + "\r\n");
			
			System.out.println(result.toString());
			result.setLength(0);
		}
		
		// 第二次查询前,做更新操作,会刷新二级缓存,防止数据脏读
//		Product product = new Product();
//		product.setProductId(230270);
//		product.setProductPrice(92.8);
//		levelCacheMapper.updateProductInstance(product);
		
		SqlSession sqlSession2 = sqlSession;
		LevelCacheMapper levelCacheMapper2 = sqlSession2.getMapper(LevelCacheMapper.class);
		List<ProductInstance> resultList2 = levelCacheMapper2.queryProductInstance(230270);
		result.setLength(0);
	
		System.out.println("商品名：" + resultList2.get(0).getProductName());
		System.out.println("商品价格：" + resultList2.get(0).getProductPrice() + "\r\n");
		
		for(int i=0; i<resultList2.size(); i++) {
			List<ProductAppraise> appraiseList2 = resultList2.get(i).getProductAppraiseList();
			ProductAppraise productAppraise = appraiseList2.get(0);
			result.append("商品评分：" + productAppraise.getProductScore() + "\r\n");
			result.append("评价用户id：" + productAppraise.getUserId() + "\r\n");
			
			System.out.println(result.toString());
			result.setLength(0);
		}

		sqlSession.close();
		sqlSession2.close();
	}
	
	public static void main(String[] args) throws Exception {
//		LevelCacheTest levelCache1 = new LevelCacheTest();
//		levelCache1.Level1CacheInstance();
		
		LevelCacheTest levelCache2 = new LevelCacheTest();
		levelCache2.Level2CacheInstance();
	}

}
