package com.gowtham.service;

import com.gowtham.exception.ServiceException;
import com.gowtham.model.Seat;

public class TestSeatService{

	public static void main(String[] args) throws ServiceException{
		Seat seat = new Seat(); 
		seat.setNumber(10);
		seat.setActive(true);
		SeatService seatService = new SeatService();
			System.out.println("No of rows updated: "+seatService.save(seat));
			System.out.println("No of rows updated: "+seatService.update(seat));
			System.out.println("No of rows updated: "+seatService.delete(seat));
	}
}
