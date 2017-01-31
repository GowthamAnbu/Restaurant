package com.gowtham.validator;

import java.time.LocalDateTime;

import com.gowtham.exception.ValidationException;
import com.gowtham.model.Food;
import com.gowtham.model.Order;
import com.gowtham.model.OrderFood;
import com.gowtham.util.ValidationUtil;

public class OrderFoodValidator {
	private void validateOrder(Order order) throws ValidationException {
		if (ValidationUtil.isNotValid(order)) {
				throw new ValidationException("Invalid Order Input");
		}
	}
	
	private void validateOrderFood(OrderFood orderFood) throws ValidationException {
		if (ValidationUtil.isNotValid(orderFood)) {
				throw new ValidationException("Invalid OrderFood Input");
		}
	}
	
	private void validateOrderFoodId(Integer orderFoodId)throws ValidationException{
		if (ValidationUtil.isNotValid(orderFoodId)) {
			throw new ValidationException("Invalid OrderFoodId Input"); 
		}
	}
	
	private void validateOrderId(Integer seatNumber)throws ValidationException{
		if (ValidationUtil.isNotValid(seatNumber)) {
			throw new ValidationException("Invalid SeatNumber Input"); 
		}
	}
	
	private void validateFood(Food food) throws ValidationException {
		if (ValidationUtil.isNotValid(food)) {
				throw new ValidationException("Invalid Food Input");
		}
	}
	
	private void validateFoodId(Integer id)throws ValidationException{
		if (ValidationUtil.isNotValid(id)) {
			throw new ValidationException("Invalid FoodId Input"); 
		}
	}
	
	private void validateQuantity(Integer quantity)throws ValidationException{
		if (ValidationUtil.isNotValid(quantity)) {
			throw new ValidationException("Invalid Quantity Input"); 
		}
	}
	
	private void validateTime(LocalDateTime time)throws ValidationException{
		if (ValidationUtil.isNotValid(time)){
			throw new ValidationException("Invalid Time Input");
		}
	}
	
	private void validateStatus(String status)throws ValidationException{
		if (ValidationUtil.isNotValid(status)) {
			throw new ValidationException("Invalid Status Input"); 
		}
	}
	
	public void validateSave(OrderFood orderFood)throws ValidationException{
		validateOrderFood(orderFood);
		validateOrderFoodId(orderFood.getId());
		validateOrder(orderFood.getOrder());
		validateOrderId(orderFood.getOrder().getId());
		validateFood(orderFood.getFood());
		validateFoodId(orderFood.getFood().getId());
		validateQuantity(orderFood.getQuantity());
		validateTime(orderFood.getOrderedTime());
		validateStatus(orderFood.getStatus());
	}
	
	
	public void validateUpdate(OrderFood orderFood)throws ValidationException{
		validateOrderFood(orderFood);
		validateOrderFoodId(orderFood.getId());
		validateStatus(orderFood.getStatus());
	}
	
	public void validateDelete(OrderFood orderFood)throws ValidationException{
		validateOrderFood(orderFood);
		validateOrderFoodId(orderFood.getId());
	}
	
}
