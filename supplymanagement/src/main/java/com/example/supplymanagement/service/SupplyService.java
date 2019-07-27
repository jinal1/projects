package com.example.supplymanagement.service;

import java.util.List;

import com.example.supplymanagement.model.supply;

public interface SupplyService {
	public supply addSupply(supply p);
	public List<supply> getAllSupply();
	public supply getSupplyById(String id);
	public boolean deleteSupply(String id);
	public boolean checkProductExistenceById(String id);
	public boolean checkVendorExistenceById(String id);
}
