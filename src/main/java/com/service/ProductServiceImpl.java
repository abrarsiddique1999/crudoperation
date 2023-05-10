package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Product;
import com.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;

	@Override
	public Product addProduct(Product product) {

		return productRepo.save(product);
	}

	@Override
	public Product updateProduct(int id, Product product) throws Exception {
		Product product2 = productRepo.findById(id)
				.orElseThrow(() -> new Exception("Product Doesn't Exists with id : " + id));
		productRepo.delete(product2);
		return productRepo.save(product);
	}

	@Override
	public String deleteProductById(int id) throws Exception {
		Product product2 = productRepo.findById(id)
				.orElseThrow(() -> new Exception("Product Doesn't Exists with id : " + id));
		productRepo.delete(product2);
		return "Product Deleted With Id : " + id;
	}

	@Override
	public List<Product> getAllProduct() throws Exception {
		List<Product> products = productRepo.findAll();

		if (products == null) {
			throw new Exception("Products are Not exists in Data");
		}
		return products;
	}

	@Override
	public Product getProductById(int id) throws Exception {

		return productRepo.findById(id).orElseThrow(() -> new Exception("Product Doesn't Exists with id : " + id));
	}

}
