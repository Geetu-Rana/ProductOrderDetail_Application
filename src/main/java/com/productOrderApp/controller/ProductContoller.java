package com.productOrderApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productOrderApp.Exception.ProductException;
import com.productOrderApp.Service.ProductService;
import com.productOrderApp.Service.ProductServiceImpl;
import com.productOrderApp.model.Product;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductContoller {
	
	
	private ProductService pServ;
	
	@Autowired
	public ProductContoller(ProductServiceImpl pserv ) {
		this.pServ = pserv;
	}
	
	@PostMapping("/save")
	public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product product) throws ProductException{
		Product prod = pServ.createProduct(product);
		
		return new ResponseEntity<Product>(prod, HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("/{id}/{qty}")
	public ResponseEntity<Product> adjustProductQuantity(@PathVariable("id") Long Id, @PathVariable("qty") Long qty) throws ProductException{
		Product prod = pServ.adjustPoductQuantity(Id, qty);
		
		return new ResponseEntity<>(prod, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Product>> getAllProducts() throws ProductException{
		List<Product> prod = pServ.getAllProducts();
		return new ResponseEntity<List<Product>>(prod, HttpStatus.ACCEPTED);
	}
}
