package com.productOrderApp.Service;

import java.util.List;

import com.productOrderApp.Exception.ProductException;
import com.productOrderApp.model.Product;

public interface ProductService {
	
	public Product createProduct(Product product) throws ProductException;
	
	public Product adjustPoductQuantity(Long product_id, Long quantity) throws ProductException;
	
	public List<Product> getAllProducts() throws ProductException;
	
}
