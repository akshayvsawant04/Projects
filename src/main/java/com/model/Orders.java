package com.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	private String status;
	private Date orderDate;
	private Double orderAmount;
	private int quantity;
	private Long totalPrice;

	@ManyToOne
	@JoinColumn(name="customer_id")
	@JsonBackReference
	private Customer customer;

	@OneToOne
	@JoinColumn(name="payment_id")
	private Payment payment;
	
	@OneToMany
	@JsonManagedReference
	@JoinColumn(name="product_id")
	private List<Product> product;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(Long id, String status, Date orderDate, Double orderAmount, int quantity, Long totalPrice,
			Customer customer, Payment payment, List<Product> product) {
		super();
		this.id = id;
		this.status = status;
		this.orderDate = orderDate;
		this.orderAmount = orderAmount;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.customer = customer;
		this.payment = payment;
		this.product = product;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

}
