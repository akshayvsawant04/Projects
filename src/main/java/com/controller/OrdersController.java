package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Orders;
import com.service.OrdersServiceImpl;

@RestController
public class OrdersController {

	@Autowired
	private OrdersServiceImpl orderServiceImpl;
	
	@PostMapping("/getAllOrders")
	public ResponseEntity<List<Orders>> getAllOrders(){
		List<Orders> orders = orderServiceImpl.getAllOrders();
		if(orders != null)
			return new ResponseEntity<>(orders, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
	
	@GetMapping("/findByOrderId/{id}")
	public ResponseEntity<Orders> findByOrderId(@PathVariable Long id){
		Orders orders = orderServiceImpl.findOrderById(id);
		if(orders != null)
			return new ResponseEntity<>(orders, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
	
	@GetMapping("/findByOrderId/{id}")
	public ResponseEntity<String> orderStatus(@PathVariable Long id){
		String status = orderServiceImpl.status(id);
		if(status != null)
			return new ResponseEntity<>(status, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
}
