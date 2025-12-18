package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.model.Orders;

public interface OrderRepositry extends JpaRepository<Orders, Long>{
	
	@Query("select s from Orders o where quantity > 5")
	public List<Orders> findOrdersByQuantity();
	
//	@Query("select o from Orders s where s.quantity=(select max(s1.quantity) from Orders s1)")
//	public Orders findMaxQuantityFromOrders();

}
