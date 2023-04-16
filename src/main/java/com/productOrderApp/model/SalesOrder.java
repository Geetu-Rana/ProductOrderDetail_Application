package com.productOrderApp.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
@Entity
public class SalesOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long sales_Id;
	
	@NotNull
	private String customer;

	private LocalDateTime timeStamp;
	
	@OneToMany(mappedBy = "salesOrder", cascade = CascadeType.ALL)
	private List<OrderDetail> orderDetails;
	
}
