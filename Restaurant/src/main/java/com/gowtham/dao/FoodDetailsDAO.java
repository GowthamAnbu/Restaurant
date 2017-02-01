package com.gowtham.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.gowtham.model.Food;
import com.gowtham.model.FoodDetails;
import com.gowtham.model.Session;
import com.gowtham.util.ConnectionUtil;

public class FoodDetailsDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	
	public int save(final FoodDetails foodDetails) {

		final String sql = "insert into FOOD_SESSION_MAINTENANCE(FOOD_ID,SESSION_ID,QUANTITY) values(?,?,?)";
		final Object[] params = {foodDetails.getFood().getId(),foodDetails.getSession().getId(),foodDetails.getQuantity()};
		return jdbcTemplate.update(sql,params);

	}
	
	public int update(final Integer id,final Integer quantity){
		final String sql="update FOOD_SESSION_MAINTENANCE set QUANTITY=? where ID=?";
		return jdbcTemplate.update(sql,quantity,id);
	}
	
	public int delete(final Integer id){
		
		final String sql="delete from FOOD_SESSION_MAINTENANCE WHERE ID=?";
		return jdbcTemplate.update(sql, id);
	}
	
	public List<FoodDetails> list(){
		final String sql="SELECT ID,FOOD_ID,SESSION_ID,QUANTITY FROM FOOD_SESSION_MAINTENANCE";
		return jdbcTemplate.query(sql, (rs,rowNum)->{
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
	}

}
