package com.gowtham.dao;

import com.gowtham.model.Food;
import com.gowtham.model.FoodDetails;
import com.gowtham.model.Session;

public class TestFoodDetails {

	public static void main(String[] args) {
		
		Food food = new Food();
		food.setId(15);
		
		Session session = new Session();
		session.setId(4);
		
		FoodDetails foodDetails = new FoodDetails();
		foodDetails.setFood(food);
		foodDetails.setSession(session);
		foodDetails.setQuantity(100);
		
		FoodDetailsDAO foodDetailsDAO = new FoodDetailsDAO();
		foodDetailsDAO.save(foodDetails);
		foodDetailsDAO.update(17, 21);
		foodDetailsDAO.delete(17);
		foodDetailsDAO.list();
	}

}
