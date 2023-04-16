package com.productOrderApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productOrderApp.Exception.ProductException;
import com.productOrderApp.Exception.SalesOrderException;
import com.productOrderApp.Service.SaleOrderService;
import com.productOrderApp.Service.SalesOrderServiceImpl;
import com.productOrderApp.model.SalesOrder;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/salesOrder")
public class SalesOrderController {
	
	private SaleOrderService salesOrderServ;
	
	@Autowired
	public SalesOrderController(SalesOrderServiceImpl soImpl) {
		this.salesOrderServ = soImpl;
	}
	
	@PostMapping("/add")
	public ResponseEntity<SalesOrder> addSalesOrder(@Valid @RequestBody SalesOrder so) throws SalesOrderException, ProductException {
		SalesOrder salesOr =  salesOrderServ.addSalesOrder(so);
		return new ResponseEntity<SalesOrder>(salesOr,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<SalesOrder>> getAllSalesOrder() throws SalesOrderException{
		List<SalesOrder> list = salesOrderServ.allSaleOrder();
		return new ResponseEntity<List<SalesOrder>>(list, HttpStatus.ACCEPTED);
	}
}
