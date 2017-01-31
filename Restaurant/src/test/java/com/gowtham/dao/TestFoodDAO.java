package com.gowtham.dao;

import com.gowtham.model.Food;

public class TestFoodDAO {

	public static void main(String[] args) {
		Food food = new Food();
		food.setId(15);
		food.setName("yuvraj");
		food.setPrice(200);
		
		FoodDAO foodDAO = new FoodDAO();
		foodDAO.save(food);
		foodDAO.update(15,100);
		foodDAO.delete(15);
		foodDAO.list();
		foodDAO.ispresent("Tea");
	}

}
