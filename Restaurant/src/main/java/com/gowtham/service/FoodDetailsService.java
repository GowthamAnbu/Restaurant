package com.gowtham.service;

import com.gowtham.dao.FoodDetailsDAO;
import com.gowtham.exception.ServiceException;
import com.gowtham.exception.ValidationException;
import com.gowtham.model.FoodDetails;
import com.gowtham.validator.FoodDetailsValidator;

public class FoodDetailsService {
	private FoodDetailsValidator foodDetailsValidator = new FoodDetailsValidator();
	private FoodDetailsDAO foodDetailsDAO = new FoodDetailsDAO();
	
	public void save(FoodDetails foodDetails) throws ServiceException{
		try {
			foodDetailsValidator.validateSave(foodDetails);
			foodDetailsDAO.save(foodDetails);
		} catch (ValidationException e) {
			throw new ServiceException("unable to Insert Seat");
		}	
	}

	public void update(FoodDetails foodDetails) throws ServiceException{
		try {
			foodDetailsValidator.validateUpdate(foodDetails);
			foodDetailsDAO.update(foodDetails.getId(),foodDetails.getQuantity());
		} catch (ValidationException e) {
			throw new ServiceException("unable to Update Seat");
		}	
	}
	
	public void delte(FoodDetails foodDetails) throws ServiceException{
		try {
			foodDetailsValidator.validateDelete(foodDetails);
			foodDetailsDAO.delete(foodDetails.getId());
		} catch (ValidationException e) {
			throw new ServiceException("unable to Delete Seat");
		}	
	}
	
}
