package com.gowtham.validator;

import java.time.LocalDateTime;

import com.gowtham.exception.ValidationException;
import com.gowtham.model.Food;
import com.gowtham.model.Order;
import com.gowtham.model.OrderFood;
import com.gowtham.util.ValidationUtil;

public class OrderFoodValidator {
	private void validateOrder(Order order) throws ValidationException {
		ValidationUtil.isNotValid(order,"Invalid Order Input");
	}
	
	private void validateOrderFood(OrderFood orderFood) throws ValidationException {
		ValidationUtil.isNotValid(orderFood,"Invalid OrderFood Input");
	}
	
	private void validateOrderFoodId(Integer orderFoodId)throws ValidationException{
		ValidationUtil.isNotValid(orderFoodId,"Invalid OrderFoodId Input");
	}
	
	private void validateOrderId(Integer seatNumber)throws ValidationException{
		ValidationUtil.isNotValid(seatNumber,"Invalid SeatNumber Input");
	}
	
	private void validateFood(Food food) throws ValidationException {
		ValidationUtil.isNotValid(food,"Invalid Food Input");
	}
	
	private void validateFoodId(Integer id)throws ValidationException{
		ValidationUtil.isNotValid(id,"Invalid FoodId Input");
	}
	
	private void validateQuantity(Integer quantity)throws ValidationException{
		ValidationUtil.isNotValid(quantity,"Invalid Quantity Input");
	}
	
	private void validateTime(LocalDateTime time)throws ValidationException{
		ValidationUtil.isNotValid(time,"Invalid Time Input");
	}
	
	private void validateStatus(String status)throws ValidationException{
		ValidationUtil.isNotValid(status,"Invalid Status Input");
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
