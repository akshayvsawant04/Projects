package com.service;

import com.model.Customer;

public interface CustomerService {

	public Customer createCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer);
	
	public Customer getCustomerById(Long id);
	
	public void deleteCustomer(Long id);
}
