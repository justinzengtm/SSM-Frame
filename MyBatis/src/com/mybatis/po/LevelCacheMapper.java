package com.mybatis.po;

import java.util.List;

// 一级/二级缓存Mapper代理接口
public interface LevelCacheMapper {
	public List<ProductInstance> queryProductInstance(int id) throws Exception;
	public void updateProductInstance(Product product) throws Exception;
}
