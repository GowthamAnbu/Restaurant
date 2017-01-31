package com.gowtham.validator;

import com.gowtham.exception.ValidationException;
import com.gowtham.model.Order;
import com.gowtham.model.Seat;
import com.gowtham.util.ValidationUtil;

public class OrderValidator {
	private void validateOrder(Order order) throws ValidationException {
		if (ValidationUtil.isNotValid(order)) {
				throw new ValidationException("Invalid Order Input");
		}
	}
	
	private void validateOrderId(Integer seatNumber)throws ValidationException{
		if (ValidationUtil.isNotValid(seatNumber)) {
			throw new ValidationException("Invalid SeatNumber Input"); 
		}
	}
	
	private void validateSeat(Seat seat) throws ValidationException {
		if (ValidationUtil.isNotValid(seat)) {
				throw new ValidationException("Invalid Seat Input");
		}
	}
	
	private void validateSeatNumber(Integer seatNumber)throws ValidationException{
		if (ValidationUtil.isNotValid(seatNumber)) {
			throw new ValidationException("Invalid SeatNumber Input"); 
		}
	}
		
	private void validateTotalPrice(Integer totalPrice)throws ValidationException{
		if (ValidationUtil.isNotValid(totalPrice)) {
			throw new ValidationException("Invalid TotalPrice Input"); 
		}
	}
	
	private void validateStatus(String status)throws ValidationException{
		if (ValidationUtil.isNotValid(status)) {
			throw new ValidationException("Invalid Status Input"); 
		}
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
