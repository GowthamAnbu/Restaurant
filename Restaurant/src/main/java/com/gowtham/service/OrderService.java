package com.gowtham.service;

import com.gowtham.dao.OrderDAO;
import com.gowtham.exception.ServiceException;
import com.gowtham.exception.ValidationException;
import com.gowtham.model.Order;
import com.gowtham.validator.OrderValidator;

public class OrderService {
	private OrderValidator orderValidator = new OrderValidator();
	private OrderDAO orderDAO = new OrderDAO();
	
	public int save(Order order) throws ServiceException{
		try {
			orderValidator.validateSave(order);
			return orderDAO.save(order);
		} catch (ValidationException e) {
			throw new ServiceException("unable to Insert Seat");
		}	
	}
	
	public int update(Order order) throws ServiceException{
		try {
			orderValidator.validateUpdate(order);
			return orderDAO.update(order.getId(),order.getStatus());
		} catch (ValidationException e) {
			throw new ServiceException("unable to Update Seat");
		}	
	}

	public int delete(Order order) throws ServiceException{
		try {
			orderValidator.validateDelete(order);
			return orderDAO.delete(order.getId());
		} catch (ValidationException e) {
			throw new ServiceException("unable to Delete Seat");
		}	
	}
	
}
