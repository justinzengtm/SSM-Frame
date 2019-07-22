package com.mybatis.po;

import java.io.Serializable;
import java.util.List;

// 商品表查询包装类
public class ProductInstance extends Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ProductAppraise> appraiseList; // 商品的顾客评价信息列表
	
	public ProductInstance() {
		super();
	}
	
	public ProductInstance(int productId, String productName, double productPrice, 
			List<ProductAppraise> productAppraiseList) {
		super(productId, productName, productPrice);
		this.appraiseList = productAppraiseList;
	}

	public List<ProductAppraise> getProductAppraiseList() {
		return appraiseList;
	}

	public void setProductAppraiseList(List<ProductAppraise> productAppraiseList) {
		this.appraiseList = productAppraiseList;
	}
}
