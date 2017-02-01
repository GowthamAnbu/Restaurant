package com.gowtham.validator;

import com.gowtham.exception.ValidationException;
import com.gowtham.model.Food;
import com.gowtham.util.ValidationUtil;

public class FoodValidator {
	private void validateFood(Food food) throws ValidationException {
		ValidationUtil.isNotValid(food,"Invalid Food Input");
	}
	
	private void validateId(Integer id)throws ValidationException{
			ValidationUtil.isNotValid(id,"Invalid Id Input");
		}
	
	private void validateName(String name)throws ValidationException{
		ValidationUtil.isNotValid(name,"Invalid Name Input");
	}
	
	private void validatePrice(Integer price)throws ValidationException{
		ValidationUtil.isNotValid(price,"Invalid Price Input");
	}
	
	
	public void validateSave(Food food) throws ValidationException{
		validateFood(food);
		validateId(food.getId());
		validateName(food.getName());
		validatePrice(food.getPrice());
	}
	
	public void validateUpdate(Food food) throws ValidationException{
		validateFood(food);
		validateId(food.getId());
		validatePrice(food.getPrice());
	}
	
	public void validateDelete(Food food) throws ValidationException{
		validateFood(food);
		validateId(food.getId());
	}
}
