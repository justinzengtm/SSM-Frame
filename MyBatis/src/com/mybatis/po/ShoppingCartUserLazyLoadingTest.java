package com.mybatis.po;

import java.util.List;

// 延迟加载示例Mapper代理
public interface ShoppingCartUserLazyLoadingTest {
	public List<ShoppingCartUserLazyLoading> searchLazyLoading() throws Exception;
	
	public User searchUserById(int id) throws Exception;
}
