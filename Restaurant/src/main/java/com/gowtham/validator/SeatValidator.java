package com.gowtham.validator;

import com.gowtham.exception.ValidationException;
import com.gowtham.model.Seat;
import com.gowtham.util.ValidationUtil;


public class SeatValidator{
	
	private void validateSeat(Seat seat) throws ValidationException {
		ValidationUtil.isNotValid(seat,"Invalid Seat");
	}
	
	private void validateSeatNumber(Integer seatnumber)throws ValidationException{
		ValidationUtil.isNotValid(seatnumber,"Invalid Seatnumber");
	}
	
	private void validateActive(Boolean active)throws ValidationException{
		ValidationUtil.isNotValid(active,"Invalid Active");
	}
	
	public void validateSave(Seat seat) throws ValidationException{
		validateSeat(seat);
		validateSeatNumber(seat.getNumber());
		validateActive(seat.getActive());
	}
	
	public void validateUpdate(Seat seat) throws ValidationException{
		validateSeat(seat);
		validateSeatNumber(seat.getNumber());
		validateActive(seat.getActive());
	}
	
	public void validateDelete(Seat seat) throws ValidationException{
		validateSeat(seat);
		validateSeatNumber(seat.getNumber());
	}
	
}
