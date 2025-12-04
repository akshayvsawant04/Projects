package com.service;

import java.util.List;

import com.model.Orders;

public interface OrdersService {
	
	public List<Orders> getAllOrders();
	
	//public Orders getDetailsOfSingleOrder(Long id);
	
	public Orders findOrderById(Long id);
	
	public String status(Long id);

}
