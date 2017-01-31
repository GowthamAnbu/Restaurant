package com.gowtham.service;

import com.gowtham.dao.LimitDAO;
import com.gowtham.exception.ServiceException;
import com.gowtham.exception.ValidationException;
import com.gowtham.model.Limit;
import com.gowtham.validator.LimitValidator;

public class LimitService {

	private LimitValidator limitValidator = new LimitValidator();
	private LimitDAO limitDAO = new LimitDAO();

	public void save(Limit limit) throws ServiceException {
		try {
			limitValidator.validateSave(limit);
			limitDAO.save(limit);
		} catch (ValidationException e) {
			throw new ServiceException("unable to Insert Seat");
		}
	}
	
	public void update(Limit limit) throws ServiceException {
		try {
			limitValidator.validateUpdate(limit);
			limitDAO.update(limit.getId(),limit.getMaxLimit());
		} catch (ValidationException e) {
			throw new ServiceException("unable to Update Seat");
		}
	}
	
	public void delete(Limit limit) throws ServiceException {
		try {
			limitValidator.validateDelete(limit);
			limitDAO.delete(limit.getId());
		} catch (ValidationException e) {
			throw new ServiceException("unable to delete Seat");
		}
	}
	
}
