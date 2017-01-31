package com.gowtham.dao;

import com.gowtham.model.Seat;

public class TestSeatDAO {

	public static void main(String[] args) {
		Seat seat = new Seat();
		seat.setNumber(null);
		seat.setActive(false);

		SeatDAO seatDAO = new SeatDAO();

//		SeatValidator seatValidator = new SeatValidator();
//		seatValidator.validateSave(seat);
		seatDAO.save(seat);
		seatDAO.delete(11);
		seatDAO.list();
		System.out.println(seatDAO.isPresent(1));
		seatDAO.isActive(1);
	}

}
