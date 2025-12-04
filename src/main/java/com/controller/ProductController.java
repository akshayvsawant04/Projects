package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Product;
import com.service.ProductServiceImpl;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@PostMapping("/addProduct")
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		Product prod = productServiceImpl.addProduct(product);
		if(prod != null)
			return new ResponseEntity<>(prod, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
	
	@GetMapping("/getAllProduct")
	public ResponseEntity<List<Product>> getAllProduct(){
		List<Product> prod = productServiceImpl.getAllProduct();
		if(prod != null)
			return new ResponseEntity<>(prod, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
	
	@DeleteMapping("/deleteSingleProduct/{id}")
	public void deleteSingleProduct(@PathVariable Long id) {
		productServiceImpl.deleteSingleProduct(id);
	}
	
	@DeleteMapping("/deleteAllProduct")
	public void deleteAllProduct() {
		productServiceImpl.deleteAllProduct();
	}
	
	@DeleteMapping("/deleteByCategory")
	public ResponseEntity<Boolean> deleteByCategory(@PathVariable String category) {
		productServiceImpl.deleteByCategory(category);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/findByCategory")
	public ResponseEntity<List<Product>> findByCategory(@PathVariable String category){
		List<Product> prod = productServiceImpl.findByCategory(category);
		if(prod != null)
			return new ResponseEntity<>(prod, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
	
}
