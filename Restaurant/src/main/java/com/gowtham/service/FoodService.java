package com.gowtham.service;

import com.gowtham.dao.FoodDAO;
import com.gowtham.exception.ServiceException;
import com.gowtham.exception.ValidationException;
import com.gowtham.model.Food;
import com.gowtham.validator.FoodValidator;

public class FoodService {

	private FoodValidator foodValidator = new FoodValidator();
	private FoodDAO limitDAO = new FoodDAO();
	
	public int save(Food food) throws ServiceException {
		try {
			foodValidator.validateSave(food);
			return limitDAO.save(food);
		} catch (ValidationException e) {
			throw new ServiceException("unable to Insert Seat",e);
		}
	}
	
	public int update(Food food) throws ServiceException {
		try {
			foodValidator.validateUpdate(food);
			return limitDAO.update(food.getId(),food.getPrice());
		} catch (ValidationException e) {
			throw new ServiceException("unable to Update Seat",e);
		}
	}
	
	public int delete(Food food) throws ServiceException {
		try {
			foodValidator.validateDelete(food);
			return limitDAO.delete(food.getId());
		} catch (ValidationException e) {
			throw new ServiceException("unable to delete Seat",e);
		}
	}
	
}
