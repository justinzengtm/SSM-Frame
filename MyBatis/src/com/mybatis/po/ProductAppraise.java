package com.mybatis.po;

import java.io.Serializable;

public class ProductAppraise implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int productId; // 商品id
	private double productScore; // 商品评分
	private int userId; // 评分顾客id
	// ......其他属性
	
	public ProductAppraise() {
		
	}
	
	public ProductAppraise(int productId, double productScore, int userId) {
		this.productId = productId;
		this.productScore = productScore;
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public double getProductScore() {
		return productScore;
	}

	public void setProductScore(double productScore) {
		this.productScore = productScore;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
