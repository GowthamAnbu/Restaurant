package com.gowtham.service;

import com.gowtham.dao.OrderFoodDAO;
import com.gowtham.exception.ServiceException;
import com.gowtham.exception.ValidationException;
import com.gowtham.model.OrderFood;
import com.gowtham.validator.OrderFoodValidator;

public class OrderFoodService {
	private OrderFoodValidator orderFoodValidator = new OrderFoodValidator();
	private OrderFoodDAO orderFoodDAO = new OrderFoodDAO();
	
	public int save(OrderFood orderFood) throws ServiceException{
		try {
			orderFoodValidator.validateSave(orderFood);
			return orderFoodDAO.save(orderFood);
		} catch (ValidationException e) {
			throw new ServiceException("unable to Insert Seat",e);
		}	
	}
	
	public int update(OrderFood orderFood) throws ServiceException{
		try {
			orderFoodValidator.validateUpdate(orderFood);
			return orderFoodDAO.update(orderFood.getId(),orderFood.getStatus());
		} catch (ValidationException e) {
			throw new ServiceException("unable to Update Seat",e);
		}	
	}
	
	public int delete(OrderFood orderFood) throws ServiceException{
		try {
			orderFoodValidator.validateDelete(orderFood);
			return orderFoodDAO.delete(orderFood.getId());
		} catch (ValidationException e) {
			throw new ServiceException("unable to Delete Seat",e);
		}	
	}
}
