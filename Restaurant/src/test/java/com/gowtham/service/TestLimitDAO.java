package com.gowtham.service;

import com.gowtham.exception.ServiceException;
import com.gowtham.model.Limit;

public class TestLimitDAO {

	public static void main(String[] args) throws ServiceException{
		Limit limit = new Limit();
		limit.setId(null);
		limit.setName("this is new");
		limit.setMaxLimit(10);
		LimitService limitService = new LimitService();
			System.out.println("No of rows inserted: "+ limitService.save(limit));
			System.out.println("No of rows updated: "+ limitService.update(limit));
			System.out.println("No of rows deleted: "+ limitService.delete(limit));
	}

}
