package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Orders;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private Orders orders;

	@Override
	public String getStatus(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public String getStatus(Long id) {
//		Long id = orders.getId();
//		return null;
//	}

}
