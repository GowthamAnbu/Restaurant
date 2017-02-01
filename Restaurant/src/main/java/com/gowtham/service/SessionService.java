package com.gowtham.service;

import com.gowtham.dao.SessionDAO;
import com.gowtham.exception.ServiceException;
import com.gowtham.exception.ValidationException;
import com.gowtham.model.Session;
import com.gowtham.validator.SessionValidator;

public class SessionService {
	private SessionValidator sessionValidator = new SessionValidator();
	private SessionDAO sessionDAO = new SessionDAO();
	
	public int save(Session session) throws ServiceException{
		try {
			sessionValidator.validateSave(session);
			return sessionDAO.save(session);
		} catch (ValidationException e) {
			throw new ServiceException("unable to Insert Seat");
		}	
	}
	
	public int update(Session session) throws ServiceException{
		try {
			sessionValidator.validateUpdate(session);
			return sessionDAO.update(session.getId(),session.getStartTime(),session.getEndTime());
		} catch (ValidationException e) {
			throw new ServiceException("unable to Update Seat");
		}	
	}
	
	public int delete(Session session) throws ServiceException{
		try {
			sessionValidator.validateDelete(session);
			return sessionDAO.delete(session.getId());
		} catch (ValidationException e) {
			throw new ServiceException("unable to Delete Seat");
		}	
	}
	
}
