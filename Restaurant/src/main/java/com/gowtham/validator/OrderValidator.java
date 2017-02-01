package com.gowtham.validator;

import com.gowtham.exception.ValidationException;
import com.gowtham.model.Order;
import com.gowtham.model.Seat;
import com.gowtham.util.ValidationUtil;

public class OrderValidator {
	private void validateOrder(Order order) throws ValidationException {
		ValidationUtil.isNotValid(order,"Invalid Order Input");
	}
	
	private void validateOrderId(Integer seatNumber)throws ValidationException{
		ValidationUtil.isNotValid(seatNumber,"Invalid SeatNumber Input");
	}
	
	private void validateSeat(Seat seat) throws ValidationException {
		ValidationUtil.isNotValid(seat,"Invalid Seat Input");
	}
	
	private void validateSeatNumber(Integer seatNumber)throws ValidationException{
		ValidationUtil.isNotValid(seatNumber,"Invalid SeatNumber Input");
	}
		
	private void validateTotalPrice(Integer totalPrice)throws ValidationException{
		ValidationUtil.isNotValid(totalPrice,"Invalid TotalPrice Input");
	}
	
	private void validateStatus(String status)throws ValidationException{
		ValidationUtil.isNotValid(status,"Invalid Status Input");
	}
	
	public void validateSave(Order order)throws ValidationException{
		validateOrder(order);
		validateSeat(order.getSeat());
		validateSeatNumber(order.getSeat().getNumber());
		validateTotalPrice(order.getTotalPrice());
		validateStatus(order.getStatus());
	}

	public void validateUpdate(Order order)throws ValidationException{
		validateOrder(order);
		validateOrderId(order.getId());
		validateStatus(order.getStatus());
	}
	
	public void validateDelete(Order order)throws ValidationException{
		validateOrder(order);
		validateOrderId(order.getId());
	}
	
}
