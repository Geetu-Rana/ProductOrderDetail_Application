package com.productOrderApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productOrderApp.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
