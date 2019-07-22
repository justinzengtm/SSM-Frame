package com.mybatis.po;

import java.io.Serializable;

// 购物车表查询包装类
public class ShoppingCartInstance extends ShoppingCart implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user; //对应用户
	
	public ShoppingCartInstance() {
		
	}
	
	public ShoppingCartInstance(int cartId, int userId, int productId, 
			String productName, int number, 
			double price, User user) {
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
