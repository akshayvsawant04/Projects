package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Product;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
	
	public List<Product> findByCategory(String category);
	
	void deleteByCategory(String category);

}
