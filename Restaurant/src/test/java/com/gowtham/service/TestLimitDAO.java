package com.gowtham.service;

import com.gowtham.dao.LimitDAO;
import com.gowtham.model.Limit;

public class TestLimitDAO {

	public static void main(String[] args) {
		Limit limit = new Limit();
		limit.setId(2);
		limit.setName("SEATS");
		limit.setMaxLimit(10);
		
		LimitDAO limitDAO = new LimitDAO();
		limitDAO.save(limit);
		limitDAO.update(2, 5);
		limitDAO.delete(2);
		limitDAO.list();
	}

}
