package com.example.supplymanagement.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class supply {
	@Id
	private String supplyId;
	private String productId;
	private String vendorId;
	private double purchaseQuality;
	private Date supplyDate;
	public String getSupplyId() {
		return supplyId;
	}
	public void setSupplyId(String supplyId) {
		this.supplyId = supplyId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	public double getPurchaseQuality() {
		return purchaseQuality;
	}
	public void setPurchaseQuality(double purchaseQuality) {
		this.purchaseQuality = purchaseQuality;
	}
	public Date getSupplyDate() {
		return supplyDate;
	}
	public void setSupplyDate(Date supplyDate) {
		this.supplyDate = supplyDate;
	}

	
	

}
