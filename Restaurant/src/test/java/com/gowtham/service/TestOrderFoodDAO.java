package com.gowtham.service;

import java.time.LocalDateTime;

import com.gowtham.dao.OrderFoodDAO;
import com.gowtham.model.Food;
import com.gowtham.model.Order;
import com.gowtham.model.OrderFood;

public class TestOrderFoodDAO {

	public static void main(String[] args) {
		Order order = new Order();
		order.setId(38);
		
		Food food = new Food();
		food.setId(14);
		
		OrderFood orderFood = new OrderFood();
		orderFood.setOrder(order);
		orderFood.setFood(food);
		orderFood.setQuantity(2);
		orderFood.setOrderedTime(LocalDateTime.parse("2017-01-25T12:30:00"));
		orderFood.setStatus("Ordered");
		
		
		OrderFoodDAO orderFoodDAO = new OrderFoodDAO();
		orderFoodDAO.save(orderFood);
		orderFoodDAO.update(29, "Cancelled");
		orderFoodDAO.delete(29);
		orderFoodDAO.list();
		orderFoodDAO.isOrdered(1,8);
	}

}
