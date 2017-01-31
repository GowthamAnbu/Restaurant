package com.gowtham.validator;

import java.time.LocalTime;

import com.gowtham.exception.ValidationException;
import com.gowtham.model.Session;
import com.gowtham.util.ValidationUtil;

public class SessionValidator {

	private void validateSession(Session session) throws ValidationException {
		if (ValidationUtil.isNotValid(session)) {
				throw new ValidationException("Invalid Session Input");
		}
	}
	
	private void validateId(Integer id)throws ValidationException{
			if (ValidationUtil.isNotValid(id)) {
				throw new ValidationException("Invalid Id Input"); 
			}
		}
	
	private void validateName(String name)throws ValidationException{
		if (ValidationUtil.isNotValid(name)){
			throw new ValidationException("Invalid Name Input");
		}
	}
	
	private void validateTime(LocalTime time)throws ValidationException{
		if (ValidationUtil.isNotValid(time)){
			throw new ValidationException("Invalid Time Input");
		}
	}
	
	public void validateSave(Session session)throws ValidationException{
		validateSession(session);
		validateId(session.getId());
		validateName(session.getName());
		validateTime(session.getStartTime());
		validateTime(session.getEndTime());
	}
	
	public void validateUpdate(Session session)throws ValidationException{
		validateSession(session);
		validateId(session.getId());
		validateTime(session.getStartTime());
		validateTime(session.getEndTime());
	}
	
	public void validateDelete(Session session)throws ValidationException{
		validateSession(session);
		validateId(session.getId());
	}
	
}
