package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.model.Customer;
import com.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/createCustomer")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
		Customer cust = customerService.createCustomer(customer);
		if(cust != null)
			return new ResponseEntity<>(cust,HttpStatus.CREATED);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/updateCustomer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
		Customer cust = customerService.updateCustomer(customer);
		if(cust != null)
			return new ResponseEntity<>(cust,HttpStatus.CREATED);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/findCustomerById/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
		Customer cust = customerService.getCustomerById(id);
		if(cust != null)
			return new ResponseEntity<>(cust,HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		//best practice is but for this from service impl w should return optional type
		//return customerServiceImpl.getCustomerById(id).map(cust -> ResponseEntity.OK(cust)).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/deleteCustomer/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);
	}

}
