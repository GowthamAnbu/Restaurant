package com.gowtham.dao;

import java.util.List;
import java.util.ListIterator;

import org.springframework.jdbc.core.JdbcTemplate;

import com.gowtham.model.Food;
import com.gowtham.util.ConnectionUtil;

public class FoodDAO {
	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	
	public void save(final Food food) {

		final String sql = "insert into SEED_FOOD (ID,NAME,PRICE) values(?,?,?)";
		final Object[] params = { food.getId(),food.getName(),food.getPrice()};
		final int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}
	
	public void update(final Integer id,final Integer price) {

		final String sql = "update SEED_FOOD set PRICE=? where ID=?";
		final int rows = jdbcTemplate.update(sql,price,id);
		System.out.println("No of rows updated: " + rows);

	}
	
	public void delete(final Integer id) {

		final String sql = "delete from SEED_FOOD where ID=?";
		final int rows = jdbcTemplate.update(sql, id);
		System.out.println("No of rows deleted: " + rows);

	}

	public void list(){
		final String sql="select ID,NAME,PRICE FROM SEED_FOOD";
		final List<Food> list=jdbcTemplate.query(sql, (rs,rowNum)->{
			final Food food=new Food();
			food.setId(rs.getInt("ID"));
			food.setName(rs.getString("NAME"));
			food.setPrice(rs.getInt("Price"));
			return food;
		});
		final ListIterator<Food> listIterator=list.listIterator();
		while(listIterator.hasNext()){
			System.out.println(listIterator.next());
		}
	}
	public void ispresent(String name){
		String sql="select isitem_present(?)";
		Object[] args={name};
		System.out.println(jdbcTemplate.queryForObject(sql, args, Boolean.class));
	}
}
