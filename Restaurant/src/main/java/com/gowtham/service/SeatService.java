package com.gowtham.service;

import java.sql.SQLException;

import com.gowtham.dao.SeatDAO;
import com.gowtham.exception.ValidationException;
import com.gowtham.exception.ServiceException;
import com.gowtham.model.Seat;
import com.gowtham.validator.SeatValidator;

public class SeatService {

	private SeatValidator seatValidator = new SeatValidator();
	private SeatDAO seatDAO = new SeatDAO();

	public int save(Seat seat) throws ServiceException {

		try {
			seatValidator.validateSave(seat);
			seatDAO.isPresent(seat.getNumber(),"Seat already present");
			return seatDAO.save(seat);
		} catch (ValidationException | SQLException e) {
			throw new ServiceException("unable to Insert Seat",e);
		}

	}
	
	public int update(Seat seat) throws ServiceException{

		try {
			seatValidator.validateUpdate(seat);
			seatDAO.isNotPresent(seat.getNumber(),"Seat not present");
			return seatDAO.update(seat);
			}
		catch (ValidationException | SQLException e) {
			throw new ServiceException("unable to Update Seat",e);
		}

	}
	
	public int delete(Seat seat) throws ServiceException{

		try {
			seatValidator.validateDelete(seat);
			seatDAO.isNotPresent(seat.getNumber(),"Seat not present");
			return seatDAO.delete(seat.getNumber());
		} catch (ValidationException | SQLException e) {
			throw new ServiceException("unable to delete Seat",e);
		}

	}
	
}
