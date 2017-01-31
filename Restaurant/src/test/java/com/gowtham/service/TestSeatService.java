package com.gowtham.service;

import com.gowtham.exception.SeatFoundException;
import com.gowtham.exception.SeatNotFoundException;
import com.gowtham.exception.ServiceException;
import com.gowtham.model.Seat;

public class TestSeatService {

	public static void main(String[] args) throws SeatNotFoundException, SeatFoundException {
		Seat seat = new Seat(); 
		seat.setNumber(null);
		seat.setActive(false);
		
		SeatService seatService = new SeatService();
		try {
			seatService.save(seat);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}

}
