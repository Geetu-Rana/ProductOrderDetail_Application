package com.productOrderApp.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productOrderApp.Exception.ProductException;
import com.productOrderApp.Exception.SalesOrderException;
import com.productOrderApp.model.OrderDetail;
import com.productOrderApp.model.Product;
import com.productOrderApp.model.SalesOrder;
import com.productOrderApp.repository.SalesOrderRepository;
@Service
public class SalesOrderServiceImpl implements SaleOrderService {
	
	@Autowired
	private SalesOrderRepository soRepo;
	
	@Autowired
	private ProductServiceImpl prodServ;
	
	@Override
	public SalesOrder addSalesOrder(SalesOrder salesOrder) throws SalesOrderException, ProductException {
		Optional<SalesOrder> opt = soRepo.findById(salesOrder.getSales_Id());
		if(opt.isPresent()) {
			throw new SalesOrderException("Sales Order Allready exist !");
		}
		salesOrder.setTimeStamp(LocalDateTime.now());
		for(OrderDetail o : salesOrder.getOrderDetails()) {
			Product product = prodServ.findById(o.getProduct().getProductId());
			if(product.getStockQuantity()<o.getSaleQuantity()) {
				throw new ProductException("Insufficient Stock for product "+ product.getName());
			}
			
			product.setStockQuantity(product.getStockQuantity() - o.getSaleQuantity());
			prodServ.save(product);
			o.setSalesOrder(salesOrder);
		}
		
		return soRepo.save(salesOrder);
	}

	@Override
	public List<SalesOrder> allSaleOrder() throws SalesOrderException {
		List<SalesOrder> totalSales = soRepo.findAll();
		if(totalSales.isEmpty()) {
			throw new SalesOrderException("No Sales Order exist!");
		}
		return totalSales;
	}
	
}
