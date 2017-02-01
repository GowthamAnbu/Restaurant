package com.gowtham.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.gowtham.model.Food;
import com.gowtham.util.ConnectionUtil;

public class FoodDAO {
	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	
	public int save(final Food food) {

		final String sql = "insert into SEED_FOOD (ID,NAME,PRICE) values(?,?,?)";
		final Object[] params = { food.getId(),food.getName(),food.getPrice()};
		return jdbcTemplate.update(sql, params);

	}
	
	public int update(final Integer id,final Integer price) {

		final String sql = "update SEED_FOOD set PRICE=? where ID=?";
		return jdbcTemplate.update(sql,price,id);

	}
	
	public int delete(final Integer id) {

		final String sql = "delete from SEED_FOOD where ID=?";
		return  jdbcTemplate.update(sql, id);

	}

	public List<Food> list(){
		final String sql="select ID,NAME,PRICE FROM SEED_FOOD";
		return jdbcTemplate.query(sql, (rs,rowNum)->{
			final Food food=new Food();
			food.setId(rs.getInt("ID"));
			food.setName(rs.getString("NAME"));
			food.setPrice(rs.getInt("Price"));
			return food;
		});
	}
	public Boolean ispresent(String name){
		String sql="select isitem_present(?)";
		Object[] args={name};
		return jdbcTemplate.queryForObject(sql, args, Boolean.class);
	}
}
