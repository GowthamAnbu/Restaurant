package com.gowtham.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.gowtham.model.Food;
import com.gowtham.model.Order;
import com.gowtham.model.OrderFood;
import com.gowtham.util.ConnectionUtil;

public class OrderFoodDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	
	public int save(final OrderFood orderFood){
		final String sql="insert into ORDER_FOOD_MAINTENANCE (ORDER_ID,FOOD_ID,QUANTITY,ORDERED_TIME,STATUS) VALUES(?,?,?,?,?)";
		final Object[] params={orderFood.getOrder().getId(),orderFood.getFood().getId(),orderFood.getQuantity(),orderFood.getOrderedTime(),orderFood.getStatus()};
		return jdbcTemplate.update(sql, params);
	}
	
	public int update(final Integer id,final String status){
		final String sql="update ORDER_FOOD_MAINTENANCE set STATUS=? where ID=?";
		return jdbcTemplate.update(sql,status,id);
	}
	
	public int delete(final Integer id){
		
		final String sql="delete from ORDER_FOOD_MAINTENANCE WHERE ID=?";
		return jdbcTemplate.update(sql, id);
	}
	
	public List<OrderFood> list(){
		final String sql="SELECT ID,ORDER_ID,FOOD_ID,QUANTITY,ORDERED_TIME,STATUS FROM ORDER_FOOD_MAINTENANCE";
		return jdbcTemplate.query(sql, (rs,rowNum)->{
			final OrderFood orderFood = new OrderFood();
			orderFood.setId(rs.getInt("ID"));
			final Order order = new Order();
			order.setId(rs.getInt("ORDER_Id"));
			orderFood.setOrder(order);
			final Food food = new Food();
			food.setId(rs.getInt("FOOD_ID"));
			orderFood.setFood(food);
			orderFood.setQuantity(rs.getInt("QUANTITY"));
			orderFood.setOrderedTime(rs.getTimestamp("ORDERED_TIME").toLocalDateTime());
			orderFood.setStatus(rs.getString("STATUS"));
			return orderFood;
		});
	}
	public Boolean isOrdered(Integer orderId,Integer foodId){
		String sql="select isfood_ordered(?,?)";
		Object[] args={orderId,foodId};
		return jdbcTemplate.queryForObject(sql, args, Boolean.class);
	}
}
