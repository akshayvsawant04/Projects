package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customException.ResourceNotFound;
import com.dao.CustomerRepository;
import com.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer createCustomer(Customer customer) {
		Optional<Customer> existing = customerRepository.findByEmail(customer.getEmail());

		if (existing.isPresent()) {
			throw new ResourceNotFound("Email already exists: " + customer.getEmail());
		}

		customer.setFullName(customer.getFirstName()+ " " + customer.getMiddleName() + " " + customer.getLastName());
		return customerRepository.save(customer);

	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer existing = customerRepository.findById(customer.getId()).orElseThrow(() -> new ResourceNotFound("Customer not found"));

		//shortcut
		//return customerRepository.save(customer);

		//good practice
		existing.setMiddleName(customer.getFirstName());
		existing.setMiddleName(customer.getMiddleName());
		existing.setLastName(customer.getLastName());
		existing.setFullName(customer.getFirstName()+ " " + customer.getMiddleName() + " " + customer.getLastName());
		existing.setEmail(customer.getEmail());
		existing.setPhoneNumber(customer.getPhoneNumber());
		existing.setDateOfBirth(customer.getDateOfBirth());

		existing.setAddress(customer.getAddress());

		return customerRepository.save(existing);
	}

	@Override
	public Customer getCustomerById(Long id) {
		return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Customer not present"));
	}

	@Override
	public void deleteCustomer(Long id) {
		Customer cust = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Customer not found"));
		customerRepository.delete(cust);
	}

}
