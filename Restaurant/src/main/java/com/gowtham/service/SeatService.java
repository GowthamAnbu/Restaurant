package com.gowtham.service;

import java.util.List;

import com.gowtham.dao.SeatDAO;
import com.gowtham.exception.ServiceException;
import com.gowtham.exception.ValidationException;
import com.gowtham.model.Seat;
import com.gowtham.validator.SeatValidator;

public class SeatService {

	private SeatValidator seatValidator = new SeatValidator();
	private SeatDAO seatDAO = new SeatDAO();

	public int save(Seat seat) throws ServiceException {

		try {
			seatValidator.validateSave(seat);
			Boolean result = seatDAO.isPresent(seat.getNumber());
			if(result){
				throw new ServiceException("Seat already present");
			}
			return seatDAO.save(seat);
		} catch (ValidationException e) {
			throw new ServiceException("unable to Insert Seat",e);
		}

	}
	
	public int update(Seat seat) throws ServiceException{

		try {
			seatValidator.validateSave(seat);
			Boolean result = seatDAO.isPresent(seat.getNumber());
			if(!result){
				throw new ServiceException("Seat not present");
			}
			return seatDAO.update(seat);
			}
		catch (ValidationException e) {
			throw new ServiceException("unable to Update Seat",e);
		}

	}
	
	public int delete(Seat seat) throws ServiceException{

		try {
			seatValidator.validateDelete(seat);
			Boolean result = seatDAO.isPresent(seat.getNumber());
			if(!result){
				throw new ServiceException("Seat not present");
			}
			return seatDAO.delete(seat.getNumber());
		} catch (ValidationException e) {
			throw new ServiceException("unable to delete Seat",e);
		}

	}
	
	public List<Seat> findAll(){
			return seatDAO.findAll();
	}
	
	public Seat findOne(Seat seat) throws ServiceException{

		try {
			seatValidator.validateDelete(seat);
			return seatDAO.findOne(seat.getNumber());
		} catch (ValidationException e) {
			throw new ServiceException("invalid number input",e);
		}

	}
	
	public boolean isActive(Seat seat) throws ServiceException{

		try {
			seatValidator.validateDelete(seat);
			return seatDAO.isActive(seat.getNumber());
		} catch (ValidationException e) {
			throw new ServiceException("invalid number input",e);
		}

	}
}

