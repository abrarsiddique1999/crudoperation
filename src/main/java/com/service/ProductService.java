package com.service;

import java.util.List;

import com.entity.Product;

public interface ProductService {

	Product addProduct(Product product);

	Product updateProduct(int id, Product product) throws Exception;

	String deleteProductById(int id) throws Exception;

	List<Product> getAllProduct() throws Exception;

	Product getProductById(int id) throws Exception;

}
