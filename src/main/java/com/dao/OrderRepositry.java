package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Orders;

public interface OrderRepositry extends JpaRepository<Orders, Long>{
	

}
