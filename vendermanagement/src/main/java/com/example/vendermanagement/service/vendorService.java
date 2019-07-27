package com.example.vendermanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.vendermanagement.model.vendor;


public interface vendorService {
	public vendor addVendor(vendor p);
	public List<vendor> getAllVendors();
	public vendor getVendorById(String id);
	public boolean checkVendorExistenceById(String id);
	public vendor updatevendor(vendor p, String id);
	public boolean deletevendor(String id);
}
