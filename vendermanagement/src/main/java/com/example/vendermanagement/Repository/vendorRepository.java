package com.example.vendermanagement.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vendermanagement.model.vendor;
public interface vendorRepository extends JpaRepository<vendor,String> {

}
