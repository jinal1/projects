package com.example.vendermanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vendermanagement.Repository.vendorRepository;
import com.example.vendermanagement.model.vendor;
import com.example.vendermanagement.service.vendorService;
@Service
public class VendorServiceImpl implements vendorService{
	@Autowired
	private  vendorRepository pr;
	public vendor addVendor(vendor p) {
		// TODO Auto-generated method stub
		pr.save(p);
		return p;
	}

	public List<vendor> getAllVendors() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	public vendor getVendorById(String id) {
		// TODO Auto-generated method stub
		vendor other=null;
		// TODO Auto-generated method stub
		return pr.findById(id).orElse(other);
	}

	public boolean checkVendorExistenceById(String id) {
		// TODO Auto-generated method stub
		return pr.existsById(id);
	}


	public boolean deletevendor(String id) {
		// TODO Auto-generated method stub
		pr.deleteById(id);
		return true;
	}

	public vendor updatevendor(vendor p, String id) {
		// TODO Auto-generated method stub
		vendor p1=getVendorById(id);
		p1.setVenderName(p.getVenderName());
		p1.setAddress(p.getAddress());
		p1.setEmail(p.getEmail());
		p1.setPhoneNumber(p.getPhoneNumber());
		
		pr.save(p1);
		return p1;
		
	}


}
