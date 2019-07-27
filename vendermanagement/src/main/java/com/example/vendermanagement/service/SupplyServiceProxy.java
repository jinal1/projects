package com.example.vendermanagement.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="supplyservice")
public interface SupplyServiceProxy {
	@GetMapping(value="/checkvendorentry/{id}")
	public ResponseEntity<Boolean> checkVendorExistenceById(@PathVariable("id") String id);
}
