package com.mybatis.test;

import java.util.List;
import java.util.Properties;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import com.mybatis.po.User;

public class UserObjectFactory extends DefaultObjectFactory {
	private static final long serialVersionUID = 1L;

	// 重写默认构造方法
	@Override
	public <T> T create(Class<T> type) {
		T ret = super.create(type);
		//判断加载的类的类型,然后执行自定义操作
		if(User.class.isAssignableFrom(type)) {
			User entity = (User)ret;
			entity.setAge(27);
		}
		return ret;
	}
	
	// 重写有参数的构造方法
	@Override
	public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes,
			List<Object>constructorArgs) {
		return super.create(type, constructorArgTypes, constructorArgs);
	}
	
	// 重写处理参数方法
	@Override
	public void setProperties(Properties properties) {
		super.setProperties(properties);
		properties.setProperty("1", "Lalisa Manoban");
		System.out.println(properties.getProperty("1"));
	}
}
