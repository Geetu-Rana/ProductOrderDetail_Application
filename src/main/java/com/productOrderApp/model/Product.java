package com.productOrderApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;
	
	@NotNull(message = "name can not be null")
	private String Name;
	
	private String description;
	
	private String brandName;
	@PositiveOrZero(message = "sale price can not be negative")
	private Double salePrice;
	
	
	@PositiveOrZero(message = "Stock quantity can not be negative")
	private Long stockQuantity;
	
}
