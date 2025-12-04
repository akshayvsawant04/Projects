package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customException.ResourceNotFound;
import com.dao.ProductRepository;
import com.model.Product;

@Service 
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public void deleteSingleProduct(Long Id) {
		Product product = productRepository.findById(Id).orElseThrow(() -> new ResourceNotFound("Product not found"));
		productRepository.delete(product);
	}

	@Override
	public void deleteAllProduct() {
		productRepository.deleteAll();
	}

	@Override
	public boolean deleteByCategory(String category) {
		List<Product> product = productRepository.findByCategory(category);
		if(product != null) {
			productRepository.deleteByCategory(category);
			return true;
		}
		return false;
	}

	@Override
	public List<Product> findByCategory(String category) {
		return  productRepository.findByCategory(category);
	}
	
}
