package com.gowtham.dao;

import com.gowtham.model.Order;
import com.gowtham.model.Seat;

public class TestOrderDAO {

	public static void main(String[] args) {
		Seat seat = new Seat();
		seat.setNumber(1);

		Order order = new Order();
		order.setSeat(seat);
		order.setTotalPrice(500);
		order.setStatus("Ordered");

		OrderDAO orderDAO = new OrderDAO();
		orderDAO.save(order);
		orderDAO.update(39, "Cancelled");
		orderDAO.delete(39);
		orderDAO.list();
		orderDAO.isAvailable(1);
		orderDAO.placeOrder(1, "FriedRice,Tea", "1,2");
		orderDAO.cancelOrder(4);
		orderDAO.cancelFoodOrder(1, "VarietyRice");
	}

}
