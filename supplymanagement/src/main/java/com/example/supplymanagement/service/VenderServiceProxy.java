package com.example.supplymanagement.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="venderservice")
public interface VenderServiceProxy {
	@GetMapping(value="/checkvendorexistencebyid/{id}")
	public ResponseEntity<Boolean> checkVendorExistenceById(@PathVariable("id") String id);

}
