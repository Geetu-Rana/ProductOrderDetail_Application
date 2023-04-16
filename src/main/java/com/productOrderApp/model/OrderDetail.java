package com.productOrderApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Positive;
import lombok.Data;
@Entity
@Data
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderDet_Id;
	
	@ManyToOne
	@JoinColumn(name = "product_Id")
	private Product product;
	
	@Positive(message = "sale Quantity can not be 0 or Negative!")
	private Integer saleQuantity;
	
	@Positive(message = "Discount can not be 0 or Negative!")
	private Double discount;
	
	@ManyToOne
	@JoinColumn(name = "sales_order_Id")
	@JsonIgnore
	private SalesOrder salesOrder;
}
