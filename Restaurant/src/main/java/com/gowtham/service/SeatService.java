package com.gowtham.service;

import com.gowtham.dao.SeatDAO;
import com.gowtham.exception.SeatNotFoundException;
import com.gowtham.model.Seat;
import com.gowtham.validator.SeatValidator;

public class SeatService {

	private SeatValidator seatValidator = new SeatValidator();
	private SeatDAO seatDAO = new SeatDAO();

	public void save(Seat s) throws SeatNotFoundException {

		try {
			seatValidator.validateSeat(s);

			if (seatDAO.isPresent(s.getNumber())) {
				throw new SeatNotFoundException("Seat already Exists");
			}
			seatDAO.save(s);//if noexception

		} catch (SeatNotFoundException e) {
			e.printStackTrace();
			throw e;
		}

	}
}
