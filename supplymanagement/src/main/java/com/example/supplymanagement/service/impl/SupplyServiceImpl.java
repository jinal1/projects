package com.example.supplymanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.supplymanagement.Repository.SupplyRepository;
import com.example.supplymanagement.model.supply;
@Service
public class SupplyServiceImpl {
@Autowired
private SupplyRepository sr;

	public supply addSupply(supply p) {
		// TODO Auto-generated method stub
		return sr.save(p);
	}

	public List<supply> getAllSupply() {
		// TODO Auto-generated method stub
		return sr.findAll();
	}

	public supply getSupplyById(String id) {
		// TODO Auto-generated method stub
		supply other=null;
		return sr.findById(id).orElse(other);
	}

	public boolean deleteSupply(String id) {
		// TODO Auto-generated method stub
		 sr.deleteById(id);
		 return true;
	}

	public boolean checkProductExistenceById(String id) {
		// TODO Auto-generated method stub
		supply s=sr.findByProductId(id);
		if(s!=null)
		{
			return true;
		}
		else
		{
		return false;
		}
	}

	public boolean checkVendorExistenceById(String id) {
		// TODO Auto-generated method stub
		supply s=sr.findByVendorId(id);
		if(s!=null)
		{
			return true;
		}
		else
		{
		return false;
		}
	}

}
