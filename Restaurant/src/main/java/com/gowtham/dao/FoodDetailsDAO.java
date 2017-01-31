package com.gowtham.dao;

import java.util.List;
import java.util.ListIterator;

import org.springframework.jdbc.core.JdbcTemplate;

import com.gowtham.model.Food;
import com.gowtham.model.FoodDetails;
import com.gowtham.model.Session;
import com.gowtham.util.ConnectionUtil;

public class FoodDetailsDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	
	public void save(final FoodDetails foodDetails) {

		final String sql = "insert into FOOD_SESSION_MAINTENANCE(FOOD_ID,SESSION_ID,QUANTITY) values(?,?,?)";
		final Object[] params = {foodDetails.getFood().getId(),foodDetails.getSession().getId(),foodDetails.getQuantity()};
		final int rows = jdbcTemplate.update(sql,params);
		System.out.println("No of rows inserted: " + rows);

	}
	
	public void update(final Integer id,final Integer quantity){
		final String sql="update FOOD_SESSION_MAINTENANCE set QUANTITY=? where ID=?";
		final int rows = jdbcTemplate.update(sql,quantity,id);
		System.out.println("No of rows updated: "+rows);
	}
	
	public void delete(final Integer id){
		
		final String sql="delete from FOOD_SESSION_MAINTENANCE WHERE ID=?";
		final int rows = jdbcTemplate.update(sql, id);
		System.out.println("No of rows deleted: "+rows);
	}
	
	public void list(){
		final String sql="SELECT ID,FOOD_ID,SESSION_ID,QUANTITY FROM FOOD_SESSION_MAINTENANCE";
		final List<FoodDetails> list=jdbcTemplate.query(sql, (rs,rowNum)->{
			final FoodDetails foodDetails = new FoodDetails();
			foodDetails.setId(rs.getInt("ID"));
			final Food food = new Food();
			food.setId(rs.getInt("FOOD_ID"));
			foodDetails.setFood(food);
			final Session session = new Session();
			session.setId(rs.getInt("SESSION_ID"));
			foodDetails.setSession(session);
			foodDetails.setQuantity(rs.getInt("QUANTITY"));
			return foodDetails;
		});
		final ListIterator<FoodDetails> listIterator=list.listIterator();
		while(listIterator.hasNext()){
			final FoodDetails foodDetails = listIterator.next();
			System.out.println("ID : "+foodDetails.getId()+" "+
			"FOOD ID : "+foodDetails.getFood().getId()+" "+
			"SESSION ID : "+foodDetails.getSession().getId()+" "+
			"QUANTITY : "+foodDetails.getQuantity());
		}
	}

}
