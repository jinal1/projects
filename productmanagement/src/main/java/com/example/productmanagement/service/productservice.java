package com.example.productmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.productmanagement.model.product;


public interface productservice {
	public product addProduct(product p);
	public List<product> getAllProducts();
	public product getProductById(String id);
	public boolean checkProductExistenceById(String id);
	public product updateproduct(product p, String id);
	public boolean deleteproduct(String id);
		
}
