package com.gowtham.service;

import com.gowtham.dao.SeatDAO;
import com.gowtham.exception.ValidationException;
import com.gowtham.exception.ServiceException;
import com.gowtham.model.Seat;
import com.gowtham.validator.SeatValidator;

public class SeatService {

	private SeatValidator seatValidator = new SeatValidator();
	private SeatDAO seatDAO = new SeatDAO();

	public void save(Seat seat) throws ServiceException {

		try {
			seatValidator.validateSave(seat);
			seatDAO.save(seat);
		} catch (ValidationException e) {
			throw new ServiceException("unable to Insert Seat");
		}

	}
	public void delete(Seat seat) throws ServiceException {

		try {
			seatValidator.validateDelete(seat);
			seatDAO.delete(seat.getNumber());
		} catch (ValidationException e) {
			throw new ServiceException("unable to delete Seat");
		}

	}
	
}
