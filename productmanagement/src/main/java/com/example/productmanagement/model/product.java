package com.example.productmanagement.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class product {
	@Id
	private String productId;
	private String productName;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getManufacturerDetails() {
		return manufacturerDetails;
	}
	public void setManufacturerDetails(String manufacturerDetails) {
		this.manufacturerDetails = manufacturerDetails;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	private String manufacturerDetails;
	private int price;
	
	

}
