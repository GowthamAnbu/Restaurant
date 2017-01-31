package com.gowtham.service;

import com.gowtham.dao.FoodDAO;
import com.gowtham.exception.ServiceException;
import com.gowtham.exception.ValidationException;
import com.gowtham.model.Food;
import com.gowtham.validator.FoodValidator;

public class FoodService {

	private FoodValidator foodValidator = new FoodValidator();
	private FoodDAO limitDAO = new FoodDAO();
	
	public void save(Food food) throws ServiceException {
		try {
			foodValidator.validateSave(food);
			limitDAO.save(food);
		} catch (ValidationException e) {
			throw new ServiceException("unable to Insert Seat");
		}
	}
	
	public void update(Food food) throws ServiceException {
		try {
			foodValidator.validateUpdate(food);
			limitDAO.update(food.getId(),food.getPrice());
		} catch (ValidationException e) {
			throw new ServiceException("unable to Update Seat");
		}
	}
	
	public void delete(Food food) throws ServiceException {
		try {
			foodValidator.validateDelete(food);
			limitDAO.delete(food.getId());
		} catch (ValidationException e) {
			throw new ServiceException("unable to delete Seat");
		}
	}
	
}
