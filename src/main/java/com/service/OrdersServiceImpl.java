package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customException.ResourceNotFound;
import com.dao.OrderRepositry;
import com.model.Orders;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrderRepositry orderRepositry;

	@Override
	public List<Orders> getAllOrders() {
		List<Orders> ord = orderRepositry.findAll();
		if (ord.isEmpty()) {
	        throw new ResourceNotFound("No orders found");
	    }
		return ord;
	}

	@Override
	public Orders findOrderById(Long id) {
		return orderRepositry.findById(id).orElseThrow(() -> new ResourceNotFound("Order not avilable"));
	}

	@Override
	public String status(Long id) {
		Orders order = orderRepositry.findById(id).orElseThrow(() -> new ResourceNotFound("Order not avilable"));
		return order.getStatus();
		
	}

}
