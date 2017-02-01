package com.gowtham.validator;

import com.gowtham.exception.ValidationException;
import com.gowtham.model.Food;
import com.gowtham.model.FoodDetails;
import com.gowtham.model.Session;
import com.gowtham.util.ValidationUtil;

public class FoodDetailsValidator {

	private void validateFoodDetails(FoodDetails foodDetails) throws ValidationException {
		ValidationUtil.isNotValid(foodDetails,"Invalid FoodDetails Input");
	}
	
	private void validateFood(Food food) throws ValidationException {
		ValidationUtil.isNotValid(food,"Invalid Food Input");
	}
	
	private void validateSession(Session session) throws ValidationException {
		ValidationUtil.isNotValid(session,"Invalid Session Input");
		
	}
	
	private void validateFoodId(Integer id)throws ValidationException{
		ValidationUtil.isNotValid(id,"Invalid FoodId Input");
	}
	
	private void validateSessionId(Integer id)throws ValidationException{
		ValidationUtil.isNotValid(id,"Invalid SessionId Input");
	}
	
	private void validateId(Integer id)throws ValidationException{
			ValidationUtil.isNotValid(id,"Invalid Id Input");
		}
	
	private void validateQuantity(Integer quantity)throws ValidationException{
		ValidationUtil.isNotValid(quantity,"Invalid Quanity Input");
	}
	
	public void validateSave(FoodDetails foodDetails)throws ValidationException{
		validateFoodDetails(foodDetails);
		validateFood(foodDetails.getFood());
		validateFoodId(foodDetails.getFood().getId());
		validateSession(foodDetails.getSession());
		validateSessionId(foodDetails.getSession().getId());
		validateId(foodDetails.getId());
		validateQuantity(foodDetails.getQuantity());
	}
	
	public void validateUpdate(FoodDetails foodDetails)throws ValidationException{
		validateFoodDetails(foodDetails);
		validateId(foodDetails.getId());
		validateQuantity(foodDetails.getQuantity());
	}
	
	public void validateDelete(FoodDetails foodDetails)throws ValidationException{
		validateId(foodDetails.getId());
	}
	
}
	
