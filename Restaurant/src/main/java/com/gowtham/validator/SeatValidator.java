package com.gowtham.validator;

import com.gowtham.exception.SeatNotFoundException;
import com.gowtham.model.Seat;

public class SeatValidator {
	
	public void validateSeat(Seat seat) throws SeatNotFoundException {
		if (seat==null) {
			
				throw new SeatNotFoundException("Invalid Seat");
			
		}
	}
	
	public void ValidateSeatNumber(Integer Number){
			if (Number==null || Number!= (Integer)Number || Number<=0) {
			try {
				throw new SeatNotFoundException("Invalid Seat Number Input");
			} catch (SeatNotFoundException e) {
				e.printStackTrace();
			}
			}
		}
	
	public void ValidateActive(Boolean Active){
		if (Active==null || Active!= (Boolean)Active) {
		try {
			throw new SeatNotFoundException("Invalid Active Input");
		} catch (SeatNotFoundException e) {
			e.printStackTrace();
		}
	}
	}
	
	public void ValidateSave(Seat seat) throws SeatNotFoundException{
		validateSeat(seat);
		ValidateSeatNumber(seat.getNumber());
		ValidateActive(seat.getActive());
	}
	
	public void Validatedelete(Seat seat) throws SeatNotFoundException{
		validateSeat(seat);
		ValidateSeatNumber(seat.getNumber());
	}
	
}
