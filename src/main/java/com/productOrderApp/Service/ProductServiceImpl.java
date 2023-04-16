package com.productOrderApp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productOrderApp.Exception.ProductException;
import com.productOrderApp.model.Product;
import com.productOrderApp.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository prodRepo;

	public Product findById(Long id) throws ProductException {
		return prodRepo.findById(id)
				.orElseThrow(() -> new ProductException("Product not found with id " + id));
	}
	
	public Product save(Product p) {
		return prodRepo.save(p);
	}

	@Override
	public Product createProduct(Product product) throws ProductException {
		Optional<Product> opt = prodRepo.findById(product.getProductId());
		if (opt.isPresent()) {
			throw new ProductException("Prodct allready exist with product id " + product.getProductId());
		} else {
			return prodRepo.save(product);
		}

	}

	@Override
	public Product adjustPoductQuantity(Long product_id, Long quantity) throws ProductException {
		Optional<Product> opt = prodRepo.findById(product_id);

		if (opt.isEmpty()) {
			throw new ProductException("Product does not exist with productId" + product_id);
		} else {
			Product product = opt.get();
			
			if(product.getStockQuantity() + quantity < 0) {
				throw new ProductException("Stock quentity can not be less than 0");
			}
			product.setStockQuantity(product.getStockQuantity() + quantity);
			return prodRepo.save(product);
		}

	}

	@Override
	public List<Product> getAllProducts() throws ProductException {
		List<Product> products = prodRepo.findAll();
		if (products.isEmpty()) {
			throw new ProductException("No product present !");
		}
		return products;
	}

}
