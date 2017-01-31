package com.gowtham.validator;

import com.gowtham.exception.SeatNotFoundException;
import com.gowtham.model.Seat;
import com.gowtham.util.ValidationUtil;


public class SeatValidator{
	
	private void validateSeat(Seat seat) throws SeatNotFoundException {
		if (seat==null) {
				throw new SeatNotFoundException("Invalid Seat");
		}
	}
	
	private void validateSeatNumber(Integer number)throws SeatNotFoundException{
			if (ValidationUtil.isNotValid(number)) {
				throw new SeatNotFoundException("Invalid Seat Number Input"); 
			}
		}
	
	private void validateActive(Boolean active)throws SeatNotFoundException{
		if (ValidationUtil.isNotValid(active)){
			throw new SeatNotFoundException("Invalid Active Input");
		}
	}
	
	public void validateSave(Seat seat) throws SeatNotFoundException{
		validateSeat(seat);
		validateSeatNumber(seat.getNumber());
		validateActive(seat.getActive());
	}
	
	public void Validatedelete(Seat seat) throws SeatNotFoundException{
		validateSeat(seat);
		validateSeatNumber(seat.getNumber());
	}
	
}
