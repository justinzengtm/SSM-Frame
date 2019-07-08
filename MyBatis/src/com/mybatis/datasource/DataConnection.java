package com.mybatis.datasource;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataConnection {
	private String resource = "SqlMapConfig.xml"; //数据源配置文件
	private SqlSessionFactory sqlSessionFactory; //会话工厂
	private SqlSession sqlSession;
	
	public SqlSession getSqlSession() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂,传入MyBatis配置文件信息
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		sqlSession = sqlSessionFactory.openSession();
		
		return sqlSession;
	}
}
