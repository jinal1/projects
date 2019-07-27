package com.example.supplymanagement.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="productservice")
public interface ProductServiceProxy {
	@GetMapping(value="/checkproductexistencebyid/{id}")
	public ResponseEntity<Boolean> checkProductExistenceById(@PathVariable("id") String id);
}
