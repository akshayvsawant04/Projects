package com.service;

import java.util.List;

import com.model.Product;

public interface ProductService {

	public Product addProduct(Product product);
	
	public List<Product> getAllProduct();
	
	public void deleteSingleProduct(Long id);
	
	public void deleteAllProduct();
	
	public boolean deleteByCategory(String category);
	
	public List<Product> findByCategory(String category); 
}
