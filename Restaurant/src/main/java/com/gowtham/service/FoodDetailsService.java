package com.gowtham.service;

import com.gowtham.dao.FoodDetailsDAO;
import com.gowtham.exception.ServiceException;
import com.gowtham.exception.ValidationException;
import com.gowtham.model.FoodDetails;
import com.gowtham.validator.FoodDetailsValidator;

public class FoodDetailsService {
	private FoodDetailsValidator foodDetailsValidator = new FoodDetailsValidator();
	private FoodDetailsDAO foodDetailsDAO = new FoodDetailsDAO();
	
	public int save(FoodDetails foodDetails) throws ServiceException{
		try {
			foodDetailsValidator.validateSave(foodDetails);
			return foodDetailsDAO.save(foodDetails);
		} catch (ValidationException e) {
			throw new ServiceException("unable to Insert Seat");
		}	
	}

	public int update(FoodDetails foodDetails) throws ServiceException{
		try {
			foodDetailsValidator.validateUpdate(foodDetails);
			return foodDetailsDAO.update(foodDetails.getId(),foodDetails.getQuantity());
		} catch (ValidationException e) {
			throw new ServiceException("unable to Update Seat");
		}	
	}
	
	public int delte(FoodDetails foodDetails) throws ServiceException{
		try {
			foodDetailsValidator.validateDelete(foodDetails);
			return foodDetailsDAO.delete(foodDetails.getId());
		} catch (ValidationException e) {
			throw new ServiceException("unable to Delete Seat");
		}	
	}
	
}
