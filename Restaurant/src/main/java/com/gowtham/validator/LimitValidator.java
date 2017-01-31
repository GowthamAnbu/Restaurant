package com.gowtham.validator;

import com.gowtham.exception.ValidationException;
import com.gowtham.model.Limit;
import com.gowtham.util.ValidationUtil;

public class LimitValidator {
	
	private void validateLimit(Limit limit) throws ValidationException {
		if (ValidationUtil.isNotValid(limit)) {
				throw new ValidationException("Invalid Limit Input");
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
	
	private void validateMaxLimit(Integer maxLimit)throws ValidationException{
		if (ValidationUtil.isNotValid(maxLimit)){
			throw new ValidationException("Invalid MaxLimit Input");
		}
	}
	
	
	public void validateSave(Limit limit) throws ValidationException{
		validateLimit(limit);
		validateId(limit.getId());
		validateName(limit.getName());
		validateMaxLimit(limit.getMaxLimit());
	}
	
	public void validateUpdate(Limit limit) throws ValidationException{
		validateLimit(limit);
		validateId(limit.getId());
		validateMaxLimit(limit.getMaxLimit());
	}
	
	public void validateDelete(Limit limit) throws ValidationException{
		validateLimit(limit);
		validateId(limit.getId());
	}
	
	
}
