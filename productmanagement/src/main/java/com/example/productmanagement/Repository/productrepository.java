package com.example.productmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.productmanagement.model.product;



public interface productrepository extends JpaRepository<product,String> {

}
