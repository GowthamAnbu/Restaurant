package com.gowtham.validator;

import java.time.LocalTime;

import com.gowtham.exception.ValidationException;
import com.gowtham.model.Session;
import com.gowtham.util.ValidationUtil;

public class SessionValidator {

	private void validateSession(Session session) throws ValidationException {
		ValidationUtil.isNotValid(session,"Invalid Session Input");
	}
	
	private void validateId(Integer id)throws ValidationException{
			ValidationUtil.isNotValid(id,"Invalid Id Input");
		}
	
	private void validateName(String name)throws ValidationException{
		ValidationUtil.isNotValid(name,"Invalid Name Input");
	}
	
	private void validateTime(LocalTime time)throws ValidationException{
		ValidationUtil.isNotValid(time,"Invalid Time Input");
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
