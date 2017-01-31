package com.gowtham.validator;

import com.gowtham.exception.ValidationException;
import com.gowtham.model.Seat;
import com.gowtham.util.ValidationUtil;


public class SeatValidator{
	
	private void validateSeat(Seat seat) throws ValidationException {
		if (seat==null) {
				throw new ValidationException("Invalid Seat");
		}
	}
	
	private void validateSeatNumber(Integer number)throws ValidationException{
			if (ValidationUtil.isNotValid(number)) {
				throw new ValidationException("Invalid Seat Number Input"); 
			}
		}
	
	private void validateActive(Boolean active)throws ValidationException{
		if (ValidationUtil.isNotValid(active)){
			throw new ValidationException("Invalid Active Input");
		}
	}
	
	public void validateSave(Seat seat) throws ValidationException{
		validateSeat(seat);
		validateSeatNumber(seat.getNumber());
		validateActive(seat.getActive());
	}
	
	public void Validatedelete(Seat seat) throws ValidationException{
		validateSeat(seat);
		validateSeatNumber(seat.getNumber());
	}
	
}
