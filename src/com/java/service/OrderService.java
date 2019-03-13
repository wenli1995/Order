package com.java.service;

import java.util.List;

import com.java.entity.Order;

public interface OrderService {
	public void addOrder(Order order);
	public void updateOrder(Order order);
	public void deleteOrder(int id);
	public List<Order> queryOrder(Order order);	
	public Order getOrderById(int id);
}

