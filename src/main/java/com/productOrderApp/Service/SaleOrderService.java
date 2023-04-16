package com.productOrderApp.Service;

import java.util.List;

import com.productOrderApp.Exception.ProductException;
import com.productOrderApp.Exception.SalesOrderException;
import com.productOrderApp.model.SalesOrder;

public interface SaleOrderService {
	
	public SalesOrder addSalesOrder( SalesOrder salesOrder) throws SalesOrderException, ProductException;
	
	public List<SalesOrder> allSaleOrder() throws SalesOrderException;
}
