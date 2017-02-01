package com.gowtham.service;

import com.gowtham.dao.FoodDAO;
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

/*final ListIterator<Food> listIterator=list.listIterator();
while(listIterator.hasNext()){
	System.out.println(listIterator.next());
}*/


/*final ListIterator<FoodDetails> listIterator=list.listIterator();
while(listIterator.hasNext()){
	final FoodDetails foodDetails = listIterator.next();
	System.out.println("ID : "+foodDetails.getId()+" "+
	"FOOD ID : "+foodDetails.getFood().getId()+" "+
	"SESSION ID : "+foodDetails.getSession().getId()+" "+
	"QUANTITY : "+foodDetails.getQuantity());
}*/


/*final ListIterator<OrderFood> listIterator=list.listIterator();
while(listIterator.hasNext()){
	final OrderFood orderFood = listIterator.next();
	System.out.println("ID : "+orderFood.getId()+" "+
	"ORDER ID : "+orderFood.getOrder().getId()+" "+
	"FOOD ID : "+orderFood.getFood().getId()+" "+
	"QUANTITY : "+orderFood.getQuantity()+" "+
	"ORDERED TIME : "+DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(orderFood.getOrderedTime())+" "+
	"STATUS : "+orderFood.getStatus());
}*/