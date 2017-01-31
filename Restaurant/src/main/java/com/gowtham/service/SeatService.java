package com.gowtham.service;

import com.gowtham.dao.SeatDAO;
import com.gowtham.exception.SeatNotFoundException;
import com.gowtham.exception.ServiceException;
import com.gowtham.model.Seat;
import com.gowtham.validator.SeatValidator;

public class SeatService {

	private SeatValidator seatValidator = new SeatValidator();
	private SeatDAO seatDAO = new SeatDAO();

	public void save(Seat s) throws ServiceException {

		try {
			seatValidator.validateSave(s);
			seatDAO.save(s);
		} catch (SeatNotFoundException e) {
			throw new ServiceException("unable to insert Seat",e);
		}

	}
}
