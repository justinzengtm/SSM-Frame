package com.mybatis.po;

import java.io.Serializable;

// 延迟加载示例实体类：查询购物清单信息，以及某一清单对应的用户信息
public class ShoppingCartUserLazyLoading extends ShoppingCart implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user; //关联的顾客实例
	
	public ShoppingCartUserLazyLoading() {
		
	}
	
	public ShoppingCartUserLazyLoading(int cartId, int userId, int productId, String productName, 
			int number, double price, User user) {
		super(cartId, userId, productId, productName, number, price);
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
