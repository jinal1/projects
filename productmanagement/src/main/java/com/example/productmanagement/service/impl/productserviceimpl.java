package com.example.productmanagement.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productmanagement.Repository.productrepository;
import com.example.productmanagement.model.product;
import com.example.productmanagement.service.productservice;
@Service
public class productserviceimpl implements  productservice{

	@Autowired
	private  productrepository pr;
	
	public List<product> getAllProducts() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	public product addProduct(product p) {
		pr.save(p);
		return p;
		
	}

	public product getProductById(String id) {
		product other=null;
	// TODO Auto-generated method stub
	return pr.findById(id).orElse(other);
	}

	@Override
	public boolean checkProductExistenceById(String id) {
		// TODO Auto-generated method stub
		return pr.existsById(id);
	}

	public product updateproduct(product p, String id) {
		// TODO Auto-generated method stub
	
		product p1=getProductById(id);
		p1.setManufacturerDetails(p.getManufacturerDetails());
		p1.setPrice(p.getPrice());
		p1.setProductName(p.getProductName());
		pr.save(p1);
		return p1;
		

	}

	public boolean deleteproduct(String id) {
		// TODO Auto-generated method stub
		
		pr.deleteById(id);
		return true;
		
	}

	

}
