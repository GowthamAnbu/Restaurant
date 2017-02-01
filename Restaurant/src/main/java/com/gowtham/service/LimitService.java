package com.gowtham.service;

import java.util.List;

import com.gowtham.dao.LimitDAO;
import com.gowtham.exception.ServiceException;
import com.gowtham.exception.ValidationException;
import com.gowtham.model.Limit;
import com.gowtham.validator.LimitValidator;

public class LimitService {

	private LimitValidator limitValidator = new LimitValidator();
	private LimitDAO limitDAO = new LimitDAO();

	public int save(Limit limit) throws ServiceException {
		try {
			limitValidator.validateSave(limit);
			return limitDAO.save(limit);
		} catch (ValidationException e) {
			throw new ServiceException("unable to Insert Seat",e);
		}
	}
	
	public int update(Limit limit) throws ServiceException {
		try {
			limitValidator.validateUpdate(limit);
			return limitDAO.update(limit);
		} catch (ValidationException e) {
			throw new ServiceException("unable to Update Seat",e);
		}
	}
	
	public int delete(Limit limit) throws ServiceException {
		try {
			limitValidator.validateDelete(limit);
			return limitDAO.delete(limit.getId());
		} catch (ValidationException e) {
			throw new ServiceException("unable to delete Seat",e);
		}
	}
	public List<Limit> findAll(){
		return limitDAO.findAll();
	}
	
	public Limit findOne(Limit limit)throws ServiceException{
		try {
			limitValidator.validateDelete(limit);
			return limitDAO.findOne(limit.getId());
		} catch (ValidationException e) {
			throw new ServiceException("unable to delete Seat",e);
		}
	}
	
}
