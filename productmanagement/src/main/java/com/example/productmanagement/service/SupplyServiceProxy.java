package com.example.productmanagement.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="supplyservice")
public interface SupplyServiceProxy {
	@GetMapping(value="/checkproductentry/{id}")
	public ResponseEntity<Boolean> checkProductExistenceById(@PathVariable("id") String id);
	

}
