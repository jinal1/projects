package com.example.supplymanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.supplymanagement.model.supply;



public interface SupplyRepository extends JpaRepository<supply,String> {
	public supply findByProductId(String productId);
	public supply findByVendorId(String vendorId);
}
