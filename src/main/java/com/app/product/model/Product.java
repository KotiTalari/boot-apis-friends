package com.app.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	
	@Id
	@Column(updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int pId;
	@Column
	private String productName;
	@Column
	private String productCost;
	@Column
	private String productExpiryDate;
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCost() {
		return productCost;
	}
	public void setProductCost(String productCost) {
		this.productCost = productCost;
	}
	@Override
	public String toString() {
		return "Product [pId=" + pId + ", productName=" + productName + ", productCost=" + productCost
				+ ", productExpiryDate=" + productExpiryDate + "]";
	}
	
}
