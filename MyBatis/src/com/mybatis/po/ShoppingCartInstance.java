package com.mybatis.po;

import java.io.Serializable;
import java.util.List;

// 购物车表一对多查询包装类
public class ShoppingCartInstance extends ShoppingCart implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private String username; //顾客姓名
//	private String gender; //性别
//	private String province; //省会
//	private String city; //城市
	private User user; //对应用户
//	private List<ProductAppraise> productAppraise; //商品评价集合
	private Product products;

	public ShoppingCartInstance() {
		
	}
	
	public ShoppingCartInstance(int cartId, int userId, int productId, 
			String productName, int number, 
			double price, User user, Product products) {
		super(cartId, userId, productId, productName, number, price);
//		this.username = username;
//		this.gender = gender;
//		this.province = province;
//		this.city = city;
		this.user = user;
//		this.productAppraise = productAppraise;
		this.products = products;
	}
	
	public Product getProducts() {
		return products;
	}

	public void setProducts(Product products) {
		this.products = products;
	}

//	public List<ProductAppraise> getProductAppraise() {
//		return productAppraise;
//	}
//
//	public void setProductAppraise(List<ProductAppraise> productAppraise) {
//		this.productAppraise = productAppraise;
//	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getGender() {
//		return gender;
//	}
//
//	public void setGender(String gender) {
//		this.gender = gender;
//	}
//
//	public String getProvince() {
//		return province;
//	}
//
//	public void setProvince(String province) {
//		this.province = province;
//	}
//
//	public String getCity() {
//		return city;
//	}
//
//	public void setCity(String city) {
//		this.city = city;
//	}
	
}
