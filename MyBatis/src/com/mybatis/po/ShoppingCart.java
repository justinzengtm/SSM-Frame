package com.mybatis.po;

import java.io.Serializable;

public class ShoppingCart implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cartId; // 购物车id
	private int userId; // 用户id
	private int productId; // 商品id
	private String productName; // 商品名
	private int number; //商品数量
	private double price; //商品价格
	
	public ShoppingCart() {
//		System.out.println("进入ShoppingCart类无参数构造方法");
	}
	
	public ShoppingCart(int cartId, int userId, int productId, String productName, int number, 
			double price) {
//		System.out.println("进入ShoppingCart类有参数构造方法");
		this.cartId = cartId;
		this.userId = userId;
		this.productId = productId;
		this.productName = productName;
		this.number = number;
		this.price = price;
		//this.user = user;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
