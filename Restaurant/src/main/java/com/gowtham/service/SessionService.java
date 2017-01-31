package com.gowtham.service;

import com.gowtham.dao.SessionDAO;
import com.gowtham.exception.ServiceException;
import com.gowtham.exception.ValidationException;
import com.gowtham.model.Session;
import com.gowtham.validator.SessionValidator;

public class SessionService {
	private SessionValidator sessionValidator = new SessionValidator();
	private SessionDAO sessionDAO = new SessionDAO();
	
	public void save(Session session) throws ServiceException{
		try {
			sessionValidator.validateSave(session);
			sessionDAO.save(session);
		} catch (ValidationException e) {
			throw new ServiceException("unable to Insert Seat");
		}	
	}
	
	public void update(Session session) throws ServiceException{
		try {
			sessionValidator.validateUpdate(session);
			sessionDAO.update(session.getId(),session.getStartTime(),session.getEndTime());
		} catch (ValidationException e) {
			throw new ServiceException("unable to Update Seat");
		}	
	}
	
	public void delete(Session session) throws ServiceException{
		try {
			sessionValidator.validateDelete(session);
			sessionDAO.delete(session.getId());
		} catch (ValidationException e) {
			throw new ServiceException("unable to Delete Seat");
		}	
	}
	
}
